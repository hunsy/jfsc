package com.hunsy.pointshop.service;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.MedalSerial;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class MedalSerialService extends BaseService<MedalSerial> {

    /**
     * 新增
     *
     * @param serial
     * @return
     */
    public boolean saveSerial(MedalSerial serial) {

        return super.insertSelective(serial) == 1;
    }

    /**
     * 编辑
     *
     * @param serial
     * @return
     */
    public boolean updateSerial(MedalSerial serial) {

        return super.updatedSelective(serial) == 1;
    }

    public MedalSerial findById(Long id) {
        MedalSerial serial = new MedalSerial();
        serial.setId(id);
        serial.setValid((byte) 1);
        return super.selectOne(serial);
    }


    public PageInfo<MedalSerial> findPage(Integer pageNo, Integer pageSize, MedalSerial params) {
        Example example = new Example(MedalSerial.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", params.getAppId());
        if (StringUtils.isNotEmpty(params.getName())) {
            criteria.andLike("name", "%" + params.getName() + "%");
        }
        example.setOrderByClause("updated_at desc");
        PageInfo<MedalSerial> pageInfo = super.selectByWhere(example, pageNo, pageSize);
        return pageInfo;
    }
}
