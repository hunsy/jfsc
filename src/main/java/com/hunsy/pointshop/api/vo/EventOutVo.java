package com.hunsy.pointshop.api.vo;

import java.io.Serializable;

public class EventOutVo implements Serializable {

    private Long id;

    private Integer score;

    private String name;

    public String getId() {
        return id + "";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
