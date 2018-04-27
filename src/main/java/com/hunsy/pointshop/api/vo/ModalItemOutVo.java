package com.hunsy.pointshop.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ModalItemOutVo implements Serializable {

    private Long id;
    /**
     * 事件系列码
     */
    private Long eventId;

    /**
     * 条件名称
     */
    private String name;

    /**
     * 获取条件(多少次事件码可以获取这个事件)
     */
    private Integer getCondition;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;


    public String getId() {
        return id + "";
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEventId() {
        return eventId + "";
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGetCondition() {
        return getCondition;
    }

    public void setGetCondition(Integer getCondition) {
        this.getCondition = getCondition;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
