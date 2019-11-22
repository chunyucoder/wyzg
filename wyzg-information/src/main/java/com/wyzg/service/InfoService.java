package com.wyzg.service;

import com.wyzg.mapper.CarMapper;
import com.wyzg.mapper.GoodsMapper;
import com.wyzg.pojo.Car;
import com.wyzg.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author coder
 * @date 2019/11/20 16:38
 */
@Service
public class InfoService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 发布车源
     * @param car  实体车
     * @return  返回车信息
     */
    public Car saveCarRes(Car car) {
        int insert = carMapper.insert(car);
        if (insert>0){
            return car;
        }
        return null;
    }

    /**
     * 发布货源
     * @param goods 商品
     * @return  返回货源信息
     */
    public Goods saveGoodsRes(Goods goods) {
        int insert = goodsMapper.insert(goods);
        if (insert>0){
            return goods;
        }
        return null;
    }
}
