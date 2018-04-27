package com.hunsy.pointshop.api.vo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class EventInVo implements Serializable {


    @NotNull
    private Long appId;

    @NotNull
    @Range(min = 0)
    private Integer score;

    @NotNull
    @Size(min = 1, max = 16)
    private String name;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
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
