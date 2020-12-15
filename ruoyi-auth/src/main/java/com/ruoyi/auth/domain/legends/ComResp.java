package com.ruoyi.auth.domain.legends;

/**
 * @author zero
 * @version 1.0
 * @title: ComResp
 * @projectName ruoyi
 * @description: TODO
 * @date 2020/12/1518:35
 */
public class ComResp<T> {

    private String chCode;
    private String code;
    private String respNo;
    private String respTime;
    private String msg;
    private T Data;

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRespNo() {
        return respNo;
    }

    public void setRespNo(String respNo) {
        this.respNo = respNo;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
