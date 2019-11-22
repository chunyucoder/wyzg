package com.wyzg.controller;

import com.wyzg.pojo.User;
import com.wyzg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coder
 * @date 2019/11/18 22:06
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码
     * @param phone 手机号码
     * @return  状态码
     */
    @PostMapping("/code")
    public ResponseEntity<Void> sendVerifyCode(String phone) {
        userService.sendVerifyCode(phone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 注册
     * @param phone 电话
     * @param password  密码
     * @param username  用户名
     * @param company   公司
     */
    @PostMapping("/registry")
    public ResponseEntity<Void> registry(
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "company") String company,
            @RequestParam(value = "code")String code
    ){
        userService.registry(phone,password,username,company,code);
        return ResponseEntity.ok(null);
    }

    /**
     * 登录接口
     * @param name  姓名
     * @param password  密码
     * @return  状态码
     */
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam(value = "name")String name,
                      @RequestParam(value = "password")String password){
        User user = userService.login(name, password);
        return ResponseEntity.ok(user);
    }
}
