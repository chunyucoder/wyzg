package com.wyzg.enums;

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
public enum ExceptionEnums {
    /**
     * 1xxxx    用户信息
     * 2xxxx    商品问题
     * 3xxxx    分类问题
     * 4xxxx    品牌问题
     * 5xxxx    规格问题
     * 6xxxx    搜索问题
     */
    USER_IS_NOT_FOUND(404,"查无此人"),
    INVALID_VERFIY_CODE(403,"验证码不正确！");

    private int code;
    private String msg;
}