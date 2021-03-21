package com.natsuki_kining.persevering;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/24 13:36
 */
@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
