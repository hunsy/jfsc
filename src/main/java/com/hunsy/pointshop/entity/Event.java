package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;
import javax.persistence.*;

public class Event extends BaseEntity{


    /**
     * 归属应用
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 创建者（开发者）
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 事件名称
     */
    private String name;

    /**
     * 事件分
     */
    private Integer score;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 删除标识 1 正常 0 删除
     */
    private Byte valid;


    /**
     * 获取归属应用
     *
     * @return app_id - 归属应用
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置归属应用
     *
     * @param appId 归属应用
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取创建者（开发者）
     *
     * @return created_by - 创建者（开发者）
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建者（开发者）
     *
     * @param createdBy 创建者（开发者）
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取事件名称
     *
     * @return name - 事件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置事件名称
     *
     * @param name 事件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取事件分
     *
     * @return score - 事件分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置事件分
     *
     * @param score 事件分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取删除标识 1 正常 0 删除
     *
     * @return valid - 删除标识 1 正常 0 删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置删除标识 1 正常 0 删除
     *
     * @param valid 删除标识 1 正常 0 删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}