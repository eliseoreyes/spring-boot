package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Mark the class make as a Spring Beans
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
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

    //Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
    }

    //Define oru destroy method
    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("In doMyCeanupStuff: "+getClass().getSimpleName());
    }
}
