package com.hunsy.pointshop.commons.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper,不能被扫描到
 *
 * @author hunsy
 * @date 2018/2/22
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
