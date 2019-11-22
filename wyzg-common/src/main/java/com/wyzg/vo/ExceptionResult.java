package com.wyzg.vo;

import com.wyzg.enums.ExceptionEnums;
import lombok.Data;

/**
 * @author coder
 * @date 2019/10/26 11:19
 */


@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums){
        this.status = exceptionEnums.getCode();
        this.message = exceptionEnums.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}