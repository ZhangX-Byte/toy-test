package com.toy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 14:14:20
 */
@SpringBootApplication(scanBasePackages = "com.toy.*")
@MapperScan(basePackages = "com.toy.repository")
public class ToyTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToyTestApplication.class, args);
    }
}
