package com.example.springconcepts.advance_di_container.beanFactory.components;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

public abstract class SingletonComponent {
    public abstract PrototypeComponent getPrototypeComponent();
}
