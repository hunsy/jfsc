package com.hunsy.pointshop.commons.constants;

/**
 * 应用的操作角色
 */
public enum AppRole {
    OWNER("owner", "拥有者"),
    MASTER("master", "管理员"),
    DEVELOPER("developer", "开发者");

    private String name;
    private String display;

    AppRole(String name, String display) {
        this.name = name;
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public String getDisplay() {
        return display;
    }
}
