package com.hunsy.pointshop.api.vo;

import java.io.Serializable;

public class MedalSerialOutVo implements Serializable {


    private Long id;
    /**
     * 名称
     */
    private String name;

    private Byte type;

    /**
     * 上下架状态 1上架 0下架
     */
    private Byte status;


    public String getId() {
        return id + "";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
