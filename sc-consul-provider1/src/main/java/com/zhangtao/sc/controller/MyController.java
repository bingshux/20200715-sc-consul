package com.zhangtao.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("test")
    public String tes(){
        return "test1111111";
    }
}
