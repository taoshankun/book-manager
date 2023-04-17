package com.library.controller.Utils;

import com.library.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tsk
 * @create 2023/3/22 - 10:20
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(RuntimeException.class)
    public Result doSystemException(RuntimeException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_ERR,null,"服务器超时，请重试");
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){

        return new Result(ex.getCode(),null,ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试");
    }
}
