package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.entity.Autor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {
    @GetMapping("/")
    public String saludo(){

        Autor miAutor = new Autor();
        miAutor.setNombre("sucho");
        miAutor.setAlta(true);
        miAutor.setId(1);

        Autor unAutor = new Autor();
        unAutor.setNombre("sucho");
        unAutor.setAlta(true);
        unAutor.setId(2);

        boolean isVerdadero = miAutor.equals(unAutor);

        log.info(">>>>>>>>" + isVerdadero + "<<<<<<<<<<<<<");

        return "Hola desde Spring boot 2021";
    }
}
