package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.NotNull;

public class LevelUpdateInVo extends LevelInVo {


    @NotNull
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
