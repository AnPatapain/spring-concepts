package com.example.springconcepts.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Fair fair = new FairImpl();
        Fair fairProxy = (Fair) Proxy.newProxyInstance(
                FairImpl.class.getClassLoader(),
                FairImpl.class.getInterfaces(),
                new FairInterceptor(fair)
        );

        System.out.println("Visitor1 10 years old");
        Visitor visitor1 = new Visitor(10);
        fairProxy.beerStall(visitor1);
        fairProxy.alcoholStall(visitor1);
        fairProxy.cigaretteStall(visitor1);

        System.out.println("----------------------");

        System.out.println("Visitor2 19 years old");
        Visitor visitor2 = new Visitor(19);
        fairProxy.beerStall(visitor2);
        fairProxy.alcoholStall(visitor2);
        fairProxy.cigaretteStall(visitor2);
    }
}
