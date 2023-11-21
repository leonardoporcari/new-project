package com.newproject.userservice.kafka;

import com.newproject.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentConsumer implements Runnable {

    @Autowired
    private UserRepository repository;

    @Override
    public void run() {

    }
}
