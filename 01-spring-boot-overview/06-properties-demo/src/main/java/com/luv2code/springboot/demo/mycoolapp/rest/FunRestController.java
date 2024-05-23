package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FunRestController {

    //Inject properties for : coach.name
    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public List<Person> sayHello(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Eliseo", "Reyes", 40));
        personList.add(new Person("David", "Reyes", 40));
        personList.add(new Person("Saul", "Reyes", 40));
        personList.add(new Person("Andres", "Reyes", 40));
        personList.add(new Person("Isaac", "Reyes", 40));
        personList.add(new Person("Abrahan", "Reyes", 40));
        return personList;
    }

    @GetMapping("/getCoach")
    public String getCoachName(){
        return this.coach;
    }

    @GetMapping("/test")
    public Person test(){
        return new Person("Eliseo", "Reyes", 40);
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return String.format("Coach: %s TeamName: %s", coach, teamName);
    }

}
