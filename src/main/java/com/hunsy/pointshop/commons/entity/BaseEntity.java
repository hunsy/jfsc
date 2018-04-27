package com.hunsy.pointshop.commons.entity;

import javax.persistence.Id;
import java.io.Serializable;


/**
 * 基类
 *
 * @author hunsy
 * @date 2018/3/22
 */
public abstract class BaseEntity implements Serializable {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
