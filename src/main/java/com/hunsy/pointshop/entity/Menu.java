package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;
import javax.persistence.*;

public class Menu extends BaseEntity {

    /**
     * 上级菜单
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    private String icon;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private Byte valid;


    /**
     * 获取上级菜单
     *
     * @return parent_id - 上级菜单
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单
     *
     * @param parentId 上级菜单
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单路径
     *
     * @return path - 菜单路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置菜单路径
     *
     * @param path 菜单路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * @return valid
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}