package com.newproject.userservice.kafka;

import com.newproject.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentConsumerRunner implements CommandLineRunner {

    private EnrollmentConsumer enrollmentConsumer;

    @Autowired
    public EnrollmentConsumerRunner(EnrollmentConsumer enrollmentConsumer) {
        this.enrollmentConsumer = enrollmentConsumer;
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(enrollmentConsumer).start();
    }
}
