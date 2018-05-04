package com.hunsy.pointshop.service;

import com.github.pagehelper.PageHelper;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.Medal;
import com.hunsy.pointshop.entity.MedalSerial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MedalService extends BaseService<Medal> {

    @Autowired
    private MedalSerialService medalSerialService;

    public boolean saveMedal(Medal medal) throws BizException {

        Medal max = findMax(medal.getSerialId());
        if (max != null && max.getGetCondition() > medal.getGetCondition()) {
            throw new BizException(RetCode.MEDAL_NOT_LT_LAST_EXIST);
        }
        boolean flag = super.insertSelective(medal) == 1;
        if (flag) {
            //更新勋章系列下勋章的数量
            MedalSerial medalSerial = medalSerialService.findById(medal.getSerialId());
            if (medalSerial != null) {
                medalSerial.setMedalNum(medalSerial.getMedalNum() + 1);
                medalSerialService.updateSerial(medalSerial);
            }
        }
        return flag;
    }

    public boolean updateMedal(Medal medal) throws BizException {

        Medal dbMedal = findById(medal.getId());
        if (dbMedal == null) {
            throw new BizException(RetCode.MEDAL_NOT_EXIST);
        }
        //变更了获取条件
        if (medal.getGetCondition() != null && dbMedal.getGetCondition() != medal.getGetCondition()) {

            Medal preMedal = preMedal(dbMedal.getSerialId(), dbMedal.getGetCondition());
            if (preMedal != null && preMedal.getGetCondition() >= medal.getGetCondition()) {
                throw new BizException(RetCode.MEDAL_NOT_LT_LAST_EXIST);
            }

            Medal nextMedal = nextMedal(dbMedal.getSerialId(), dbMedal.getGetCondition());
            if (nextMedal != null && nextMedal.getGetCondition() <= medal.getGetCondition()) {
                throw new BizException(RetCode.MEDAL_NOT_GT_NEXT_EXIST);
            }
        }

        return super.updatedSelective(medal) == 1;
    }


    public Medal findById(Long id) {
        Medal condition = new Medal();
        condition.setValid((byte) 1);
        condition.setId(id);
        return super.selectOne(condition);
    }

    /**
     * 获取系列下条件最高的那个勋章
     *
     * @return
     */
    public Medal findMax(Long serialId) {
        Example example = new Example(Medal.class);
        example.createCriteria()
                .andEqualTo("serialId", serialId)
                .andEqualTo("valid", 1);
        example.orderBy("getCondition").desc();
        PageHelper.startPage(0, 1);
        List<Medal> medals = super.selectByExample(example);
        if (medals != null && !medals.isEmpty()) {
            return medals.get(0);
        }
        return null;
    }

    /**
     * 获取系列勋章的上一个勋章
     *
     * @param serialId
     * @param condition
     * @return
     */
    public Medal preMedal(Long serialId, Integer condition) {
        Example example = new Example(Medal.class);
        example.createCriteria()
                .andEqualTo("serialId", serialId)
                .andEqualTo("valid", 1)
                .andLessThan("getCondition", condition);
        example.orderBy("getCondition").desc();
        PageHelper.startPage(0, 1);
        List<Medal> medals = super.selectByExample(example);
        if (medals != null && !medals.isEmpty()) {
            return medals.get(0);
        }
        return null;
    }

    /**
     * 获取系列勋章的下一个勋章
     *
     * @param serialId
     * @param condition
     * @return
     */
    public Medal nextMedal(Long serialId, Integer condition) {
        Example example = new Example(Medal.class);
        example.createCriteria()
                .andEqualTo("serialId", serialId)
                .andEqualTo("valid", 1)
                .andGreaterThan("getCondition", condition);
        example.orderBy("getCondition").asc();
        PageHelper.startPage(0, 1);
        List<Medal> medals = super.selectByExample(example);
        if (medals != null && !medals.isEmpty()) {
            return medals.get(0);
        }
        return null;
    }


    public Medal findBySerialAndCondition(Long serialId, Integer condition) {
        Medal medal = new Medal();
        medal.setSerialId(serialId);
        medal.setGetCondition(condition);
        medal.setValid((byte) 1);
        return super.selectOne(medal);
    }


    public List<Medal> findListBySerialId(Long serialId) {
        Example example = new Example(Medal.class);
        example.createCriteria()
                .andEqualTo("serialId", serialId)
                .andEqualTo("valid", 1);
        example.orderBy("getCondition").asc()
                .orderBy("updatedAt").desc();
        return super.selectByExample(example);
    }
}
