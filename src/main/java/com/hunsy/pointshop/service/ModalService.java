package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.Modal;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ModalService extends BaseService<Modal> {


    public boolean saveModal(Modal modal) {

        return super.insertSelective(modal) == 1;
    }

    public boolean updateModal(Modal modal) {

        return super.updatedSelective(modal) == 1;
    }


    public Modal findById(Long id) {
        Modal condition = new Modal();
        condition.setValid((byte) 1);
        condition.setId(id);
        return super.selectOne(condition);
    }


    public List<Modal> findListBySerialId(Long serialId) {
        Example example = new Example(Modal.class);
        example.createCriteria()
                .andEqualTo("serialId", serialId)
                .andEqualTo("valid", 1);
        example.orderBy("updatedAt").desc();
        return super.selectByExample(example);
    }
}
