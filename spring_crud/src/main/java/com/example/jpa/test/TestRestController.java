package com.example.jpa.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "저녁 뭐먹지?";
    }

    @GetMapping("/test2")
    public String test2(){
        return "집밥";
    }
}
