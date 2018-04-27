package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "modal_serial")
public class ModalSerial extends BaseEntity {


    @Column(name = "app_id")
    private Long appId;

    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 名称
     */
    private String name;

    private Byte type;

    /**
     * 上下架状态 1上架 0下架
     */
    private Byte status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 逻辑删除字段 1正常 0删除
     */
    private Byte valid;


    /**
     * @return app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取上下架状态 1上架 0下架
     *
     * @return status - 上下架状态 1上架 0下架
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置上下架状态 1上架 0下架
     *
     * @param status 上下架状态 1上架 0下架
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * 获取逻辑删除字段 1正常 0删除
     *
     * @return valid - 逻辑删除字段 1正常 0删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置逻辑删除字段 1正常 0删除
     *
     * @param valid 逻辑删除字段 1正常 0删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}