package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.MedalSerialInVo;
import com.hunsy.pointshop.api.vo.MedalSerialOutVo;
import com.hunsy.pointshop.api.vo.MedalSerialPageItemOutVo;
import com.hunsy.pointshop.api.vo.MedalSerialUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.constants.ModalType;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.MedalSerial;
import com.hunsy.pointshop.service.MedalSerialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/medalSerial")
public class MedalSerialApi {

    @Autowired
    private MedalSerialService medalSerialService;


    @GetMapping(value = "types")
    public ResponseEntity<Object> types() {

        return ResponseEntity.ok(DataRet.success(ModalType.getTypes()));
    }


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody MedalSerialInVo vo) {

        MedalSerial serial = new MedalSerial();
        BeanUtils.copyProperties(vo, serial);
        AppDeveloper operator = MySecurityContextUtil.getDev();
        serial.setCreatedBy(operator.getId());
        boolean flag = medalSerialService.saveSerial(serial);
        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody MedalSerialUpdateInVo vo) {

        MedalSerial serial = new MedalSerial();
        BeanUtils.copyProperties(vo, serial);
        boolean flag = medalSerialService.updateSerial(serial);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {

        MedalSerial serial = medalSerialService.findById(id);
        if (serial == null) {
            throw new BizException(RetCode.MEDAL_SERIAL_NOT_EXIST);
        }
        MedalSerialOutVo vo = new MedalSerialOutVo();
        BeanUtils.copyProperties(serial, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping("page")
    public ResponseEntity<Object> page(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            MedalSerial params) {

        PageInfo<MedalSerial> pageInfo = medalSerialService.findPage(pageNo, pageSize, params);
        List<MedalSerialPageItemOutVo> vos = new ArrayList<>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(e -> {
                MedalSerialPageItemOutVo vo = new MedalSerialPageItemOutVo();
                BeanUtils.copyProperties(e, vo);
                vos.add(vo);
            });
        }
        PageInfo<MedalSerialPageItemOutVo> voPageInfo = new PageInfo(vos);
        return ResponseEntity.ok(DataRet.success(new PageRetVo(voPageInfo)));
    }
}
