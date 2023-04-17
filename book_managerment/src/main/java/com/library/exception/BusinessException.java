package com.library.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private int code;
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
