package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MenuUpdateInVo implements Serializable {

    @NotNull
    private Long id;

    private Long parentId;

    /**
     * 菜单名称
     */
    @NotNull
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    private String icon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
