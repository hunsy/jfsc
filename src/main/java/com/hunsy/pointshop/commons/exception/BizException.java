package com.hunsy.pointshop.commons.exception;

import com.hunsy.pointshop.commons.code.RetCode;

/**
 * 自定义的异常类
 *
 * @author hunsy
 * @date 2018/1/24
 */
public class BizException extends Exception {

    private Integer code;
    private String msg;

    public BizException(RetCode retCode) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
