package com.hunsy.pointshop.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MedalSerialPageItemOutVo implements Serializable {


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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    private Integer medalNum;

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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getMedalNum() {
        return medalNum;
    }

    public void setMedalNum(Integer medalNum) {
        this.medalNum = medalNum;
    }
}
