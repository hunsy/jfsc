package com.hunsy.pointshop.api.vo;


import java.io.Serializable;

/**
 * app用于下拉选择的vo.
 */
public class AppItemOutVo implements Serializable {

    private Long id;
    private String name;



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
}
