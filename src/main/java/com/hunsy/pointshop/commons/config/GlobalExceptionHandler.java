package com.hunsy.pointshop.commons.config;


import com.alibaba.fastjson.JSON;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author hunsy
 * @date 2018/3/5
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理业务层错误信息
     *
     * @param biz
     */
    @ExceptionHandler(BizException.class)
    public DataRet bizExceptionHandler(BizException biz) {

        return DataRet.fail(biz.getCode(), biz.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataRet validException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        return new DataRet(RetCode.PARAM_ERROR.getCode(), JSON.toJSONString(error.getDefaultMessage()), null);
    }

    @ExceptionHandler(Exception.class)
    public DataRet exceptionHandler(Exception e) {
        e.printStackTrace();
        return DataRet.fail(RetCode.SYSTEM_ERROR.getCode(), RetCode.SYSTEM_ERROR.getMsg());
    }


}
