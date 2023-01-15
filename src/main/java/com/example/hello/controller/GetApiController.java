package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * packageName : com.example.hello.controller
 * className : GetApiController
 * user : jwlee
 * date : 2023/01/13
 */
@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")        // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)              // (get,post,put,delete) 다 동작됨 명시적으로 지정해줘야 한다.
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : " + name);
        return name;
    }

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/query-param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    //?user=steve&email=steve@gmail.com&age=30 SpringBoot 에서 키와 객체 필드를 매핑 시켜준다 명칭을 같게 해야 한다.
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
