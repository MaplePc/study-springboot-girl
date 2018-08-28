package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/hello", method = RequestMethod.GET)
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

//    @Value("${age}")
    private Integer age;

//    @Value("${cupSize}")
    private String cupSize;

//    @Value("${content}")
    private String content;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
//        return "Hello Spring Boot!";
//        return cupSize + " " + age;
//        return content;
//        return girlProperties.getCupSize();
        return "id: " + id;
    }
}
