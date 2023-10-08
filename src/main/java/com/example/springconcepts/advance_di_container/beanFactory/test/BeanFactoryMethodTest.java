package com.example.springconcepts.advance_di_container.beanFactory.test;


import com.example.springconcepts.advance_di_container.beanFactory.components.PrototypeComponent;
import com.example.springconcepts.advance_di_container.beanFactory.components.SingletonComponent;
import com.example.springconcepts.advance_di_container.beanFactory.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryMethodTest {
    @Test
    public void getPrototypeComponentReturnNewInstanceForEveryCall() {
        ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonComponent singletonComponent1 = appContext.getBean(SingletonComponent.class);
        SingletonComponent singletonComponent2 = appContext.getBean(SingletonComponent.class);
        PrototypeComponent prototypeComponent_ = appContext.getBean(PrototypeComponent.class);

        Assert.assertEquals(singletonComponent1, singletonComponent2);
        Assert.assertNotNull(singletonComponent1.getPrototypeComponent());
        Assert.assertNotNull(singletonComponent2.getPrototypeComponent());
        Assert.assertNotEquals(singletonComponent1.getPrototypeComponent(), singletonComponent2.getPrototypeComponent());
    }
}
