package com.example.springconcepts.di_container;

import com.example.springconcepts.di_container.config.AppConfig;
import com.example.springconcepts.di_container.manager.NotificationManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        NotificationManager notificationManager = context.getBean(NotificationManager.class);
        notificationManager.notify_();
    }
}
