package com.wyzg.exception;

import com.wyzg.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author coder
 * @date 2019/10/26 11:19
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WyzgException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}