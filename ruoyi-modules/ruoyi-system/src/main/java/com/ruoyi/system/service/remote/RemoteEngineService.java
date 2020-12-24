package com.ruoyi.system.service.remote;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.factory.RemoteUserFallbackFactory;
import com.ruoyi.system.api.model.LoginUser;
import com.ruoyi.system.dto.user.AddUsersReq;
import com.ruoyi.system.dto.user.ComResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务
 * 
 * @author ruoyi
 */
@FeignClient(value = "LEGENDS-PROCESS-ENGINE-DEV", fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteEngineService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param users
     * @return 结果
     */
    @PostMapping(value = "/lge/users")
    public ComResp addUsers(@RequestBody List<AddUsersReq> users);


    @GetMapping("/lge/groups/{id}/users")
    public ComResp<List<String>> getUsersByGroupId(@PathVariable("id") String id, @RequestParam("first") Integer first, @RequestParam("max") Integer max);
}
