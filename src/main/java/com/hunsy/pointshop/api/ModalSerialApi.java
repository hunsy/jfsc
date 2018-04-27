package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.ModalSerialInVo;
import com.hunsy.pointshop.api.vo.ModalSerialOutVo;
import com.hunsy.pointshop.api.vo.ModalSerialPageItemOutVo;
import com.hunsy.pointshop.api.vo.ModalSerialUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.constants.ModalType;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.ModalSerial;
import com.hunsy.pointshop.service.ModalSerialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/modalSerial")
public class ModalSerialApi {

    @Autowired
    private ModalSerialService modalSerialService;


    @GetMapping(value = "types")
    public ResponseEntity<Object> types() {

        return ResponseEntity.ok(DataRet.success(ModalType.getTypes()));
    }


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ModalSerialInVo vo) {

        ModalSerial serial = new ModalSerial();
        BeanUtils.copyProperties(vo, serial);
        AppDeveloper operator = MySecurityContextUtil.getDev();
        serial.setCreatedBy(operator.getId());
        boolean flag = modalSerialService.saveSerial(serial);
        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody ModalSerialUpdateInVo vo) {

        ModalSerial serial = new ModalSerial();
        BeanUtils.copyProperties(vo, serial);
        boolean flag = modalSerialService.updateSerial(serial);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {

        ModalSerial serial = modalSerialService.findById(id);
        if (serial == null) {
            throw new BizException(RetCode.MODAL_SERIAL_NOT_EXIST);
        }
        ModalSerialOutVo vo = new ModalSerialOutVo();
        BeanUtils.copyProperties(serial, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping("page")
    public ResponseEntity<Object> page(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            ModalSerial params) {

        PageInfo<ModalSerial> pageInfo = modalSerialService.findPage(pageNo, pageSize, params);
        List<ModalSerialPageItemOutVo> vos = new ArrayList<>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(e -> {
                ModalSerialPageItemOutVo vo = new ModalSerialPageItemOutVo();
                BeanUtils.copyProperties(e, vo);
                vos.add(vo);
            });
        }
        PageInfo<ModalSerialPageItemOutVo> voPageInfo = new PageInfo(vos);
        return ResponseEntity.ok(DataRet.success(new PageRetVo(voPageInfo)));
    }
}
