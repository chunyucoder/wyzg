package com.wyzg.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author coder
 * @date 2019/11/18 21:37
 */
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;
    private String name;
    private String password;
    private Integer isCompany;
    private Integer permission;
    private Integer forbidden;
    private Integer type;
}
