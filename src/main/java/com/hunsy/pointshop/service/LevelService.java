package com.hunsy.pointshop.service;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.LevelUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.Level;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class LevelService extends BaseService<Level> {

    /**
     * 新增
     *
     * @param level
     * @return
     */
    public boolean saveLevel(Level level) throws BizException {

        Level max = this.findMaxLevel(level.getAppId());
        if (max == null) {
            level.setLevel(1);
        } else {
            level.setLevel(max.getLevel() + 1);
        }
        if (level.getMinScore() < max.getMinScore()) {
            throw new BizException(RetCode.LEVEL_NEXT_MIN_SCORE);
        }
        return super.insertSelective(level) == 1;
    }


    public boolean updateLevel(Level level) throws BizException {
        Level dbLevel = findById(level.getId());
        Level max = this.findMaxLevel(dbLevel.getAppId());
        if (level.getMinScore() < max.getMinScore()) {
            throw new BizException(RetCode.LEVEL_NEXT_MIN_SCORE);
        }
        return super.updatedSelective(level) == 1;
    }

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    public Level findById(Long id) {

        Level level = new Level();
        level.setValid((byte) 1);
        level.setId(id);
        return super.selectOne(level);
    }

    /**
     * 查询应用下最大的等级
     *
     * @param appId
     * @return
     */
    public Level findMaxLevel(Long appId) {

        Example example = new Example(Level.class);
        example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", appId);
        example.setOrderByClause("level desc");

        List<Level> levels = super.selectByExample(example);
        return levels != null && !levels.isEmpty() ? levels.get(0) : null;
    }

    public PageInfo<Level> findPage(Integer pageNo, Integer pageSize, LevelUpdateInVo params) {
//        Level level = new Level();
//        BeanUtils.copyProperties(params, level);

        Example example = new Example(Level.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", params.getAppId());
        if (StringUtils.isNotEmpty(params.getName())) {
            criteria.andLike("name", "%" + params.getName() + "%");
        }

        example.setOrderByClause("level asc,updated_at desc");

        PageInfo<Level> pageInfo = super.selectByWhere(example, pageNo, pageSize);
        return pageInfo;
    }


    /**
     * '
     * 逻辑删除等级。其他的等级顺次进1位
     *
     * @param level
     */
    public void deleteLevel(Level level) {
        //删除
        level.setLevel(0);
        boolean flag = super.updatedSelective(level) == 1;
        if (flag) {
            Example example = new Example(Level.class);
            example.createCriteria()
                    .andGreaterThan("level", level.getLevel())
                    .andEqualTo("valid", 1);
            example.orderBy("level").asc();
            List<Level> levels = super.selectByExample(example);
            if (levels != null && !levels.isEmpty()) {
                levels.forEach(lv -> {
                    lv.setLevel(lv.getLevel() - 1);
                    super.updatedSelective(lv);
                });
            }
        }
    }
}
