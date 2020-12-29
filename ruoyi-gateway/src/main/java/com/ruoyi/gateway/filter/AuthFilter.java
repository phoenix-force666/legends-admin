package com.ruoyi.gateway.filter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.redis.service.RedisService;
import com.ruoyi.gateway.util.CheckUtil;
import com.ruoyi.system.api.domain.SysMenu;
import com.ruoyi.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import reactor.core.publisher.Mono;

/**
 * 网关鉴权
 * 
 * @author ruoyi
 *
 * update 20201215
 * 添加 微信登录接口过滤
 * @author Zero13
 * @Date 2020/12/15
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered
{
    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    // 排除过滤的 uri 地址，swagger排除自行添加
    // 添加 微信登录接口过滤
    private static final String[] whiteList = { "/auth/login", "/code/v2/api-docs", "/schedule/v2/api-docs",
            "/system/v2/api-docs", "/csrf", "/auth/wxlogin" };

    private static final String GATE_WAY_PREFIX = "/system";

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> sops;

    @Autowired
    private RedisService redisService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        String requestUrl = getRequestUrl(url,request);

        if (Arrays.asList(whiteList).contains(url))
        {
            return chain.filter(exchange);
        }
        String token = getToken(exchange.getRequest());
        if (StringUtils.isBlank(token))
        {
            return setUnauthorizedResponse(exchange,"令牌不能为空");
        }
        String userStr = sops.get(CacheConstants.LOGIN_TOKEN_KEY + token);
        if (StringUtils.isNull(userStr))
        {
            return setUnauthorizedResponse(exchange, "令牌验证失败");
        }
        JSONObject obj = JSONObject.parseObject(userStr);
        String userid = obj.getString("userid");
        String username = obj.getString("username");
        if (StringUtils.isBlank(userid) || StringUtils.isBlank(username))
        {
            return setUnauthorizedResponse(exchange, "令牌验证失败");
        }
        //验证权限
        JSONArray interfaces = obj.getJSONArray("interfaces");
        List<SysMenu> objects = interfaces.toJavaList(SysMenu.class);
        Stream<SysMenu> sysMenuStream = getPermissionIfs(requestUrl, request.getMethodValue(), objects);

        if(!CheckUtil.listIsNotNull(sysMenuStream.collect(Collectors.toList()))){
            return setUnauthorizedResponse(exchange,"请先获取权限!!");
       }

        // 设置用户信息到请求
        ServerHttpRequest mutableReq = exchange.getRequest().mutate().header(CacheConstants.DETAILS_USER_ID, userid)
                .header(CacheConstants.DETAILS_USERNAME, username).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        
        return chain.filter(mutableExchange);
    }

    /**
     * 获取用户path列表
     * @param token
     * @return
     */
    private LoginUser getPaths(String token) {
        return redisService.getCacheObject(CacheConstants.LOGIN_TOKEN_KEY + token);
    }

    private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, String msg)
    {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.OK);

        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            return bufferFactory.wrap(JSON.toJSONBytes(R.fail(msg)));
        }));
    }

    /**
     * 获取请求token
     */
    private String getToken(ServerHttpRequest request)
    {
        String token = request.getHeaders().getFirst(CacheConstants.HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(CacheConstants.TOKEN_PREFIX))
        {
            token = token.replace(CacheConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 获取url
     * @param requestUri
     * @param request
     * @return
     */
    public String getRequestUrl(String requestUri , ServerHttpRequest request){
            if(requestUri.startsWith(GATE_WAY_PREFIX)){
                    requestUri = requestUri.substring(GATE_WAY_PREFIX.length());
        }
        return requestUri;
    }





    /**
     * 获取目标权限资源
     *
     * @param requestUri
     * @param method
     * @param serviceInfo
     * @return
     */
    private Stream<SysMenu> getPermissionIfs(final String requestUri, final String method, List<SysMenu> serviceInfo) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        return serviceInfo.parallelStream().filter(new Predicate<SysMenu>() {
            @Override
            public boolean test(SysMenu sysMenu) {
                if(Objects.isNull(sysMenu)){
                    return false;
                }

                String uri = sysMenu.getInterfacePath();
                return (antPathMatcher.match(uri,requestUri))
                        && method.equals(sysMenu.getMethod());
            }
        });
    }

    @Override
    public int getOrder()
    {
        return -200;
    }
}