package com.wyzg.advice;

import com.wlkg.common.enums.ExceptionEnums;
import com.wlkg.common.exception.WlkgException;
import com.wlkg.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author coder
 * @date 2019/10/24 11:53
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(WlkgException e){
        ExceptionEnums em = e.getExceptionEnums();
        ExceptionResult result=new ExceptionResult(em);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
