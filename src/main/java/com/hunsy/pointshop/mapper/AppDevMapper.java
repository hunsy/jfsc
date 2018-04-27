package com.hunsy.pointshop.mapper;

import com.hunsy.pointshop.commons.mybatis.MyMapper;
import com.hunsy.pointshop.entity.AppDev;
import com.hunsy.pointshop.entity.dto.AppDevDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppDevMapper extends MyMapper<AppDev> {

    List<AppDevDto> findList(@Param("adv") AppDevDto adv);
}