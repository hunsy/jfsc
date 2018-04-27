package com.hunsy.pointshop.commons.code;

/**
 * 返回错误码。
 *
 * @author hunsy
 */
public enum RetCode {
    SUCCESS(200, "请求成功"),
    SYSTEM_ERROR(201, "系统异常"),

    //1000~1099 开发者相关异常
    DEVELOPER_EXIST(1001, "账号已被占用"),
    DEVELOPER_NOT_EXIST(1002, "账号不存在"),


    APP_DEV_NOT_EXIST(2001, "当前开发者没有这个应用"),
    APP_DEV_NOT_PERMISSION(2002, "当前开发者没有权限操作当前应用"),
    APP_DEV_HAVE_EXIST(2003, "应用已经存在这个开发者"),

    LEVEL_NOT_EXIST(3001, "等级不存在"),
    LEVEL_NEXT_MIN_SCORE(3002, "不能输入小于上一级的最小值"),

    EVENT_NOT_EXIST(4001, "事件不存在"),

    MODAL_SERIAL_NOT_EXIST(5001, "勋章系列不存在"),

    MODAL_NOT_EXIST(5101, "勋章不存在"),

    USER_NOT_EXIST(6001, "用户不存在"),;

    private Integer code;

    private String msg;

    RetCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}