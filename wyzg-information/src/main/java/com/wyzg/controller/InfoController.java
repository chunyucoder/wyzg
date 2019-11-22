package com.wyzg.controller;

import com.wyzg.pojo.Car;
import com.wyzg.pojo.Goods;
import com.wyzg.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coder
 * @date 2019/11/20 16:37
 */
@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    /**
     * 发布车源
     * @param car   车
     * @return    返回状态码
     */
    @PostMapping("/saveCar/")
    public ResponseEntity<Car> publishCar(@RequestBody Car car){
        Car res = infoService.saveCarRes(car);
        return ResponseEntity.ok(res);
    }

    /**
     * 发布货源
     * @param goods 商品
     * @return  返回状态码
     */
    @PostMapping("/saveGoods/")
    public ResponseEntity<Goods> publishGoods(@RequestBody Goods goods){

        Goods res = infoService.saveGoodsRes(goods);
        return ResponseEntity.ok(res);
    }
}
