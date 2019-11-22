package com.wyzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author coder
 * @date 2019/11/20 16:53
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wyzg.mapper")
public class InfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(InfoApplication.class,args);
    }
}
