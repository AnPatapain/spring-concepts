package com.example.springconcepts.dynamic_proxy;

public class Visitor {
    private int age;
    public Visitor(int age) {
        this.age = age;
    }
    public int getAge() {return age;}

    public void getStuff(String str) {
        System.out.println("Received: " + str);
    }
}
