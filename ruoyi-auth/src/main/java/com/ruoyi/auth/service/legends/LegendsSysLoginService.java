package com.ruoyi.auth.service.legends;

import com.ruoyi.auth.api.legends.WechatService;
import com.ruoyi.auth.domain.legends.ComReq;
import com.ruoyi.auth.domain.legends.ComResp;
import com.ruoyi.auth.domain.legends.CpLoginVO;
import com.ruoyi.auth.domain.legends.WxCpOauth2UserInfo;
import com.ruoyi.auth.form.legends.WxLoginForm;
import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.enums.UserStatus;
import com.ruoyi.common.core.exception.BaseException;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.RemoteLogService;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录校验方法
 * 
 * @author ruoyi
 */
@Component
public class LegendsSysLoginService
{
    @Autowired
    private RemoteLogService remoteLogService;

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private WechatService wechatService;

    /**
     * 登录
     */
    public LoginUser login(WxLoginForm form)
    {
        String appid = form.getAppid();
        String agentid = form.getAgentid();
        String code = form.getCode();
        // appid agentid code 为空 错误
        if (StringUtils.isAnyBlank(appid, agentid, code))
        {
            remoteLogService.saveLogininfor(agentid, Constants.LOGIN_FAIL, "微信登录必要信息空");
            throw new BaseException("微信登录必要信息空");
        }
        ComReq<CpLoginVO> wxLoginData = getWxLoginReqData(form);
        ComResp<WxCpOauth2UserInfo> wxUserInfo = wechatService.wxLogin(wxLoginData);
        // 查询用户信息
        String username = wxUserInfo.getData().getUserId();
        R<LoginUser> userResult = remoteUserService.getUserInfo(username);
        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "登录用户不存在");
            throw new BaseException("登录用户：" + username + " 不存在");
        }
        LoginUser userInfo = userResult.getData();
        SysUser user = userResult.getData().getSysUser();
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "对不起，您的账号已被删除");

            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }
        remoteLogService.saveLogininfor(username, Constants.LOGIN_SUCCESS, "登录成功");
        return userInfo;
    }

    private ComReq<CpLoginVO> getWxLoginReqData(WxLoginForm form) {
        ComReq<CpLoginVO> comReq = new ComReq();
        CpLoginVO cpLoginVO = new CpLoginVO();

        cpLoginVO.setAgentId(form.getAgentid());
        cpLoginVO.setAppId(form.getAppid());
        cpLoginVO.setCode(form.getCode());

        comReq.setData(cpLoginVO);

        return comReq;
    }

}