package com.example.springconcepts.di_container.service;

public class MailService implements NotificationService {
    @Override
    public void notify_user() {
        System.out.println("notify using mail");
    }
}
