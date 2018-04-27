package com.hunsy.pointshop.commons.response;

import com.hunsy.pointshop.commons.code.RetCode;

import java.io.Serializable;

/**
 * 响应
 */
public class DataRet implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public DataRet(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static DataRet success(Object data) {

        return new DataRet(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功,没有返回值
     *
     * @return
     */
    public static DataRet success() {

        return new DataRet(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
