package com.luv3code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getDailyWorkout();
    }

    @GetMapping("getworkout")
    public String getWorkout(){
        return myCoach.getWorkout();
    }

}
