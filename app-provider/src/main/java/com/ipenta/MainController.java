package com.ipenta;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/")
    public String say(){
        System.out.println(":: => " + System.currentTimeMillis());

        return "三大基金分";
    }
}
