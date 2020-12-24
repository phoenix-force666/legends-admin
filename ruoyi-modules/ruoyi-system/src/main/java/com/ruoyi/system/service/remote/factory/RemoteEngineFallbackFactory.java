package com.ruoyi.system.service.remote.factory;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import com.ruoyi.system.dto.user.AddUsersReq;
import com.ruoyi.system.dto.user.ComResp;
import com.ruoyi.system.service.remote.RemoteEngineService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class RemoteEngineFallbackFactory implements FallbackFactory<RemoteEngineService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteEngineFallbackFactory.class);

    @Override
    public RemoteEngineService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteEngineService()
        {
            @Override
            public ComResp addUsers(List<AddUsersReq> users) {
                return null;
            }

            @Override
            public ComResp<List<String>> getUsersByGroupId(String id,Integer first, Integer max) {
                return null;
            }
        };
    }
}
