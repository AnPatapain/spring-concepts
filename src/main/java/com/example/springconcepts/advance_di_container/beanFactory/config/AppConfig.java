package com.example.springconcepts.advance_di_container.beanFactory.config;

import com.example.springconcepts.advance_di_container.beanFactory.components.PrototypeComponent;
import com.example.springconcepts.advance_di_container.beanFactory.components.SingletonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example.springconcepts.advance_di_container.beanFactory")
public class AppConfig {
    @Bean
    @Scope("singleton")
    public SingletonComponent singletonComponent() {
        return new SingletonComponent() {
            @Override
            public PrototypeComponent getPrototypeComponent() {
                return prototypeComponent();
            }
        };
    }

    @Bean
    @Scope(value = "prototype")
    public PrototypeComponent prototypeComponent() {
        return new PrototypeComponent();
    }
}
