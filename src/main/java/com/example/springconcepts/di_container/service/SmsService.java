package com.example.springconcepts.di_container.service;

import com.example.springconcepts.di_container.service.NotificationService;

public class SmsService implements NotificationService {
    @Override
    public void notify_user() {
        System.out.println("notify using sms");
    }
}
