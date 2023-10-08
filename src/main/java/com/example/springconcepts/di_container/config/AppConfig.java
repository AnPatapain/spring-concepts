package com.example.springconcepts.di_container.config;

import com.example.springconcepts.di_container.core.ProcessorBean;
import com.example.springconcepts.di_container.manager.NotificationManager;
import com.example.springconcepts.di_container.service.MailService;
import com.example.springconcepts.di_container.service.NotificationService;
import com.example.springconcepts.di_container.service.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "mailService")
    public NotificationService mailService() {
        return new MailService();
    }

    @Bean(name = "smsService")
    public NotificationService smsService() {
        return new SmsService();
    }

    @Bean(name = "notificationManager", initMethod = "custom_post_init", destroyMethod = "custom_pre_destroy")
    public NotificationManager notificationManager() {
        return new NotificationManager();
    }

    @Bean
    public ProcessorBean processorBean() {
        return new ProcessorBean();
    }
}
