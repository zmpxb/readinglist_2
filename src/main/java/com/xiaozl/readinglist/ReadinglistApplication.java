package com.xiaozl.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 注解的意思是开启组件扫描和自动配置
@SpringBootApplication
public class ReadinglistApplication {

    /**
     * 应用程序的启动引导类（bootstrap class），也是主要的Spring配置类。
     * ReadingListApplication在Spring Boot应用程序里有两个作用：配置和启动引导。首先，
     * 这是主要的Spring配置类。虽然Spring Boot的自动配置免除了很多Spring配置，但你还需要进行
     * 少量配置来启用自动配置。
     * @param args
     */
    public static void main(String[] args) {
        // 负责启动和引导应用程序
        SpringApplication.run(ReadinglistApplication.class, args);
    }
}
