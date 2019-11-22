package com.wyzg.service;

import com.wyzg.enums.ExceptionEnums;
import com.wyzg.exception.WyzgException;
import com.wyzg.mapper.UserMapper;
import com.wyzg.pojo.User;
import com.wyzg.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author coder
 * @date 2019/11/18 22:07
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String KEY_PREFIX = "user:code:phone:";

    /**
     * 注册功能
     * @param phone 电话
     * @param password  密码
     * @param username  用户名
     * @param company   公司
     */
    public void registry(String phone, String password, String username, String company,String code) {
        //- 1）校验短信验证码
        String key=KEY_PREFIX+phone;
        String retCode = redisTemplate.opsForValue().get(key);
        if (!code.equals(retCode)){
            throw new WyzgException(ExceptionEnums.INVALID_VERFIY_CODE);
        }
        User user=new User();
        user.setPhone(phone);
        user.setName(username);
        user.setPassword(password);
        if (StringUtils.isNotBlank(company)){
            user.setIsCompany(1);
        }
        userMapper.insert(user);
    }

    /**
     * 登录接口
     * @param name  用户名
     * @param password  密码
     * @return  个人信息
     */
    public User login(String name, String password) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.selectOne(user);
    }

    /**
     * 发送手机验证码
     * @param phone 电话
     */
    public void sendVerifyCode(String phone) {
        //生成一个随机验证码
        String code = NumberUtils.generateCode(6);
        //发送短信，将验证码发送到用户手机
        try {
            Map<String ,String > map=new HashMap<>();
            map.put("phone",phone);
            map.put("code",code);
            //发送到消息队列中
            amqpTemplate.convertAndSend("wyzg.sms.exchange","sms.verify.code",map);
            //将验证码保存在redis
            redisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);
        } catch (AmqpException e) {
            e.printStackTrace();
        }
    }

}
