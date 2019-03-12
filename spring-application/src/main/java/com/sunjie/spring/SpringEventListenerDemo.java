package com.sunjie.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

public class SpringEventListenerDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        //添加事件监听器
//        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent event) {
//                System.out.println("监听事件："+event);
//            }
//        });

        //添加自定义监听器
        context.addApplicationListener(new ClosedListener());

        //添加自定义监听器
        context.addApplicationListener(new RefreshedListener());

        //启动Spring应用上下文
        context.refresh();

        //一个是ContextRefreshedEvent
        //一个是PayloadApplicationEvent
        //Spring应用上下文发布事件
        context.publishEvent("HelloWorld");//发布一个HelloWorld内容的事件
        //一个是MyEvent
        context.publishEvent(new MyEvent("HelloWorld 1"));
        //一个是ContextClosedEvent
        //关闭应用上下文
        context.close();
    }

    private static class ClosedListener implements ApplicationListener<ContextClosedEvent> {
        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.println("关闭上下文：" + event);
        }
    }

    private static class RefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("上下文启动：" + event);
        }
    }

    private static class MyEvent extends ApplicationEvent {
        public MyEvent(Object source) {
            super(source);
        }
    }

}
