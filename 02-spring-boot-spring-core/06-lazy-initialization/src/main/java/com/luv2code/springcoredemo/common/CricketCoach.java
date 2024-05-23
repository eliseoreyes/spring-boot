package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component // Mark the class make as a Spring Beans
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getWorkout(){
        return "Bench press";
    }

}
