package com.cowin.tracker.vaccine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CowinVaccineTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CowinVaccineTrackerApplication.class, args);
    }

}
