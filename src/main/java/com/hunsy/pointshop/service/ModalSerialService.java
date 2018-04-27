package com.hunsy.pointshop.service;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.ModalSerial;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class ModalSerialService extends BaseService<ModalSerial> {

    /**
     * 新增
     *
     * @param serial
     * @return
     */
    public boolean saveSerial(ModalSerial serial) {

        return super.insertSelective(serial) == 1;
    }

    /**
     * 编辑
     *
     * @param serial
     * @return
     */
    public boolean updateSerial(ModalSerial serial) {

        return super.updatedSelective(serial) == 1;
    }

    public ModalSerial findById(Long id) {
        ModalSerial serial = new ModalSerial();
        serial.setId(id);
        serial.setValid((byte) 1);
        return super.selectOne(serial);
    }


    public PageInfo<ModalSerial> findPage(Integer pageNo, Integer pageSize, ModalSerial params) {
        Example example = new Example(ModalSerial.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("appId", params.getAppId());
        if (StringUtils.isNotEmpty(params.getName())) {
            criteria.andLike("name", "%" + params.getName() + "%");
        }
        example.setOrderByClause("updated_at desc");
        PageInfo<ModalSerial> pageInfo = super.selectByWhere(example, pageNo, pageSize);
        return pageInfo;
    }
}
