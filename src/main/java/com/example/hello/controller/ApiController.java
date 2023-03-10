package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.hello.controller
 * className : ApiController
 * user : jwlee
 * date : 2023/01/13
 */
@RestController     // 해당 Class 는 REST API 처리하는 Controller
@RequestMapping("/api")     // RequestMapping URI 를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")       // http://localhost:8080/api/hello
    public String hello(){
        return "hello spring boot";
    }
}
