package org.example.api.exception;

import org.apache.commons.lang3.StringUtils;
import org.example.ResultBuilder;
import org.example.ResultCode;
import org.example.dto.Result;
import org.example.exception.LogicError;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 章春波
 * @date 2021/5/31 16:35
 * @ClassName: MyExceptionHandler
 * @Description: 统一异常处理类
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        if (e instanceof BindException) {
            BindingResult result = ((BindException) e).getBindingResult();
            return validatorCheck(result);
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
            return validatorCheck(result);
        } else if (e instanceof LogicError) {
            return ResultBuilder.failure(((LogicError) e).getResultCode(), e.getMessage());
        }
        e.printStackTrace();
        return ResultBuilder.failure(ResultCode.FAILURE, StringUtils.isNotBlank(e.getMessage()) ?
                e.getMessage() : e.toString());
    }

    public Result validatorCheck(BindingResult result) {
        StringBuffer buffer = new StringBuffer();
        for (ObjectError error : result.getAllErrors()) {
            buffer.append(error.getDefaultMessage()).append(",");
        }
        buffer.delete(buffer.length() - 1, buffer.length());
        return ResultBuilder.failure(ResultCode.FAILURE, buffer.toString());
    }
}
