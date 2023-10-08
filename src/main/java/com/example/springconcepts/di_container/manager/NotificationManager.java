package com.example.springconcepts.di_container.manager;

import com.example.springconcepts.di_container.service.NotificationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class NotificationManager implements BeanNameAware, ApplicationContextAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private final Logger logger = LoggerFactory.getLogger(NotificationManager.class);

    @Autowired
    @Qualifier("mailService")
    private NotificationService notificationService1;

    @Autowired
    @Qualifier("smsService")
    private NotificationService notificationService2;
    public void notify_() {
        System.out.println("--------------------- Business Logic ---------------------------");
        notificationService1.notify_user();
        notificationService2.notify_user();
        System.out.println("--------------------- Business Logic completed -----------------");
    }

    // Aware interface
    @Override
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware notificationManager bean name: " + beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContextAware");
    }

    // @PostConstruct @PreDestroy
    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct method executed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet of InitializingBean executed");
    }

    public void custom_post_init() {
        System.out.println("custom post init method executed");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy method executed");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy of DisposableBean executed");
    }

    public void custom_pre_destroy() {
        System.out.println("custrom pre destroy method executed");
    }
}
