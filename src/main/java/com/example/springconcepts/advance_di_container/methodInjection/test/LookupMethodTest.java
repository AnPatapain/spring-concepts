package com.example.springconcepts.advance_di_container.methodInjection.test;

import com.example.springconcepts.advance_di_container.methodInjection.components.PrototypeComponent;
import com.example.springconcepts.advance_di_container.methodInjection.components.SingletonComponent;
import com.example.springconcepts.advance_di_container.methodInjection.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookupMethodTest {
    /**
     * @Lookup can work with abstract class and concrete class. In case abstract class the annotated method
     * must be abstract. In case concrete the annotated method must be concrete (return null)
     * @Lookup won't work at all when the surrounding class is @Bean-managed. It works for @Component
     */
    @Test
    public void lookupMethodTest() {
        ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonComponent singletonComponent1 = appContext.getBean(SingletonComponent.class);
        SingletonComponent singletonComponent2 = appContext.getBean(SingletonComponent.class);

        Assert.assertEquals(singletonComponent1, singletonComponent2);
        Assert.assertNotNull(singletonComponent1.getPrototypeComponent());
        Assert.assertNotNull(singletonComponent2.getPrototypeComponent());
        Assert.assertNotEquals(singletonComponent1.getPrototypeComponent(), singletonComponent2.getPrototypeComponent());
    }
}
