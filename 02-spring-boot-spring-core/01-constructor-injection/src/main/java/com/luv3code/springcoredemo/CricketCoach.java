package com.luv3code.springcoredemo;

import org.springframework.stereotype.Component;

@Component // Mark the class make as a Spring Beans
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getWorkout(){
        return "Bench press";
    }

}
