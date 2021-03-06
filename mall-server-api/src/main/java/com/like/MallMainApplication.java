package com.like;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author like
 * @email 980650920@qq.com
 * @since 2021-02-05 17:02
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.like", "org.n3r"})
public class MallMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallMainApplication.class, args);

        System.out.println("");
        System.out.println("");
        System.out.println("                                                欢迎使用 Like Mall 商城后台");
        System.out.println("                                       后台文档地址: http://localhost:8088/doc.html");
    }
}
