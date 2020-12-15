package com.ruoyi.auth.domain.legends;

import com.ruoyi.common.core.text.UUID;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zero
 * @version 1.0
 * @title: ComReq
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1518:35
 */
public class ComReq<T> {
    String chCode = "jfpal008";
    String reqNo = UUID.fastUUID().toString(true);
    String reqTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
    String version = "1";
    T data;

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
