package com.sunjie.microservicesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class MicroservicesProjectApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MicroservicesProjectApplication.class, args);


//		new SpringApplicationBuilder(MicroservicesProjectApplication.class)
//		.properties("server.port=0")//随机向OS要可用端口
//				.run(args);

        SpringApplication springApplication = new SpringApplication(MicroservicesProjectApplication.class);
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("server.port", "0");
        springApplication.setDefaultProperties(properties);
        //设置为非web应用
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(context.getBean(MicroservicesProjectApplication.class));
        //输出当前Spring Boot应用的ApplicationContext的类名
        System.out.println("当前Spring应用上下文的类：" + context.getClass().getName());

    }

}
