package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    // API - String
    // ResponseBody 가 있으면 View 가 아닌 값만 내보낸다.
    @GetMapping("hello-string")
    @ResponseBody                   // http body에 데이터를 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;

    }

    // API - JSON
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    // Getter/Setter For name
    static class Hello {
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
    
    
}
