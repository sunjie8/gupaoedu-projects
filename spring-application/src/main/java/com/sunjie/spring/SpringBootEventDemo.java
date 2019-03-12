package com.sunjie.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {
                    System.err.println("监听到事件：" + event.getClass().getSimpleName());
                })//增加监听器
                .run(args)//运行
                .close();
    }
}
 