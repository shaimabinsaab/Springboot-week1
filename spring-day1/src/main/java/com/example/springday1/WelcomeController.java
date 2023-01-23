package com.example.springday1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/name")
    public String Getname(){

        return "my name is shaima";
    }
    @GetMapping("/age")
    public int Getage(){

        return 22;
    }
    @GetMapping("/check/statue")
    public String check(){

        return "Everything OK";
    }
    @GetMapping("/health")
    public String health(){

        return "Server health is up and running";
    }





}
