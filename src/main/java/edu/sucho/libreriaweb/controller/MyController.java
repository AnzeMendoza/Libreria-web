package edu.sucho.libreriaweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {
    @GetMapping("/")
    public String saludo(){
        log.info(">>>>>>>>>>>> prueba <<<<<<<<<<<");
        return "Hola desde Spring boot 2021";
    }
}
