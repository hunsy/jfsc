package com.hunsy.pointshop.api.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 应用新增，更新Vo
 */
public class AppInVo implements Serializable {

    private Long id;

    @NotNull(message = "应用名称不能为空")
    @Size(min = 2, max = 16, message = "应用名称必须为2~16之间的字符")
    private String name;

    public Long getId() {
        return id;
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
