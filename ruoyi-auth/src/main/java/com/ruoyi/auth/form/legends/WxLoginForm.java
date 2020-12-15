package com.ruoyi.auth.form.legends;

/**
 * @author zero
 * @version 1.0
 * @title: WxLoginForm
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1519:05
 */
public class WxLoginForm {
    private String appid;
    private String agentid;
    private String code;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
