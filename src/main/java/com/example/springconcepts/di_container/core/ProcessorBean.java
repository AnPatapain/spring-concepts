package com.example.springconcepts.di_container.core;

import com.example.springconcepts.di_container.manager.NotificationManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class ProcessorBean implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof NotificationManager) {
            System.out.println("post process before init: " + beanName);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof NotificationManager) {
            System.out.println("post process after init: " + beanName);
        }
        return bean;
    }
}
