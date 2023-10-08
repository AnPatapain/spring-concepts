package com.example.springconcepts.advance_di_container.methodInjection.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeComponent {
}
