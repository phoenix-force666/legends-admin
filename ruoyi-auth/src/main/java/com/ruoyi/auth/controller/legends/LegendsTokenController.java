package com.ruoyi.auth.controller.legends;

import com.ruoyi.auth.form.legends.WxLoginForm;
import com.ruoyi.auth.service.SysLoginService;
import com.ruoyi.auth.service.legends.LegendsSysLoginService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * token 控制
 * 
 * @author ruoyi
 */
@RestController
public class LegendsTokenController
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private LegendsSysLoginService sysLoginService;

    @PostMapping("wxlogin")
    public R<?> login(@RequestBody WxLoginForm form)
    {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form);
        // 获取登录token
        return R.ok(tokenService.createToken(userInfo));
    }

}
