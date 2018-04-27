package com.hunsy.pointshop.service;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.LevelUpdateInVo;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.Event;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EventService extends BaseService<Event> {

    /**
     * 新增
     *
     * @param event
     * @return
     */
    public boolean saveEvent(Event event) {

        return super.insertSelective(event) == 1;
    }

    /**
     * 更新
     *
     * @param event
     * @return
     */
    public boolean updateEvent(Event event) {
        return super.updatedSelective(event) == 1;
    }

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    public Event findById(Long id) {
        Event event = new Event();
        event.setValid((byte) 1);
        event.setId(id);
        return super.selectOne(event);
    }

    public List<Event> findListByName(Long appId, String name) {

        Example example = new Example(Event.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", appId);
        if (StringUtils.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        example.orderBy("updatedAt").desc();
        return super.selectByExample(example);
    }

    public PageInfo<Event> findPage(Integer pageNo, Integer pageSize, LevelUpdateInVo params) {

        Example example = new Example(Event.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", params.getAppId());
        if (StringUtils.isNotEmpty(params.getName())) {
            criteria.andLike("name", "%" + params.getName() + "%");
        }
        example.setOrderByClause("updated_at desc");
        PageInfo<Event> pageInfo = super.selectByWhere(example, pageNo, pageSize);
        return pageInfo;
    }


}
