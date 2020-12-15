package com.ruoyi.auth.domain.legends;

/**
 * @author zero
 * @version 1.0
 * @title: CpLoginVO
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1518:55
 */
public class CpLoginVO {
    private String appId;
    private String agentId;
    private String code;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
