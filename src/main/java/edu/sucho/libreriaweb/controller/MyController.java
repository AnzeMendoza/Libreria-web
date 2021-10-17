package edu.sucho.libreriaweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MyController {

    @GetMapping("/index")
    public String index(){
        log.info("MyController");
        return "index";
    }
}
