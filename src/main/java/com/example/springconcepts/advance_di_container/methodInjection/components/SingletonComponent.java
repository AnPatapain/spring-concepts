package com.example.springconcepts.advance_di_container.methodInjection.components;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {
    @Lookup
    public PrototypeComponent getPrototypeComponent() {
        return null;
    }
}
