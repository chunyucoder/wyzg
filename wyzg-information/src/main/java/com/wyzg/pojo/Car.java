package com.wyzg.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author coder
 * @date 2019/11/20 16:27
 */
@Data
@Table(name = "tb_car_resource")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startPlace;
    private String endPlace;
    private Double weight;
    private String lineType;
    private Integer count;
    private Integer status;
    private String publishName;
    private String phone;
    private String comment;
    private Date createTime;
}
