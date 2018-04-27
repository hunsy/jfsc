package com.hunsy.pointshop.commons.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.commons.entity.BaseEntity;
import com.hunsy.pointshop.commons.utils.GeneratorID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public abstract class BaseService<T extends BaseEntity> {

    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    public T selectById(Long id) {
        return this.mapper.selectByPrimaryKey(id);

    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    /**
     * 根据条件查询数据集合
     *
     * @param t
     * @return
     */
    public List<T> selectByWhere(T t) {
        return this.mapper.select(t);
    }

    /**
     * 根据条件查询一条数据
     *
     * @param t
     * @return
     */
    public T selectOne(T t) {
        return this.mapper.selectOne(t);
    }

    /**
     * 自定义example查询数据
     *
     * @param example
     * @return
     */
    public List<T> selectByExample(Example example) {
        return this.mapper.selectByExample(example);
    }

    public PageInfo<T> selectByWhere(T t, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<T> list = this.selectByWhere(t);
        return new PageInfo<T>(list);
    }

    public PageInfo<T> selectByWhere(Example t, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<T> list = this.mapper.selectByExample(t);
        return new PageInfo<T>(list);
    }

    public PageInfo<T> selectByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<T> list = this.selectAll();
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据
     *
     * @param t
     * @return 数据条数
     */
    public Integer insert(T t) {

        if (t.getId() == null) {
            t.setId(GeneratorID.getId());
        }
        return this.mapper.insert(t);
    }

    /**
     * 新增数据,null的属性不会保存,保存对象时某个属性不赋值,即不保存数据库该字段,
     *
     * @param t
     * @return
     */
    public Integer insertSelective(T t) {

        if (t.getId() == null) {
            t.setId(GeneratorID.getId());
        }
        return this.mapper.insertSelective(t);
    }

    /**
     * 根据主键id更新数据
     *
     * @param t
     * @return
     */
    public Integer updated(T t) {
        return this.mapper.updateByPrimaryKey(t);

    }

    /**
     * 主键更新数据, null的属性不会保存 ,更新对象时某个属性不赋值,即不更改数据库该字段,
     *
     * @param t
     * @return
     */
    public Integer updatedSelective(T t) {
        return this.mapper.updateByPrimaryKeySelective(t);

    }

    /**
     * 自定义example 更新数据
     *
     * @param t
     * @param example
     * @return
     */
    public Integer updatedByExampleSelective(T t, Example example) {
        return this.mapper.updateByExampleSelective(t, example);
    }

    /**
     * 根据主键id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @param property
     * @param clazz
     * @return
     */
    public Integer deleteByIds(List<Object> ids, String property, Class<T> clazz) {
        // 构造一个example
        Example example = new Example(clazz);
        // 创建一个条件
        example.createCriteria().andIn(property, ids);
        return this.mapper.deleteByExample(example);
    }

    /**
     * 根据entity删除
     *
     * @param t
     * @return
     */
    public Integer delete(T t) {
        return this.mapper.delete(t);
    }

    /**
     * 根据条件删除entity
     *
     * @param example 条件
     * @return 返回删除记录的条数
     */
    public Integer deleteByExample(Example example) {

        return this.deleteByExample(example);
    }

}
