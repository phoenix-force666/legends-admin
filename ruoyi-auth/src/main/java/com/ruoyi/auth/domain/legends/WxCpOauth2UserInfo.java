package com.ruoyi.auth.domain.legends;

/**
 * @author zero
 * @version 1.0
 * @title: WxCpOauth2UserInfo
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1518:51
 */
public class WxCpOauth2UserInfo {

    private String deviceId;
    private String expiresIn;
    private String openId;
    private String userId;
    private String userTicket;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserTicket() {
        return userTicket;
    }

    public void setUserTicket(String userTicket) {
        this.userTicket = userTicket;
    }
}
