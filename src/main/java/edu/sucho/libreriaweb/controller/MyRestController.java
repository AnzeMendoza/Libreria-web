package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.service.AutorService;
import edu.sucho.libreriaweb.service.LibroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/autor")
public class MyRestController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService libroService;

    @GetMapping(value = "/todos-json", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Autor> restJson(){
        log.info(">>>> /autor/todos-json <<<<<");
        return autorService.listarAutores();
    }

    @GetMapping(value = "/guardar-libro")
    public String crearLibro(){

        libroService.guardar();
        log.info(">>> Se guardo el registro <<<");

        return "Se guardo un libro";
    }

    @GetMapping(value = "/todos-string")
    public String restString(){
        log.info(">>>> /autor/todos-string <<<<<");
        return autorService.listarAutores().toString();
    }

    @GetMapping(value = "/obtener-id")
    public String obtenerAutor(){
        log.info(">>>> /autor/obtener-id <<<<<");

        Autor autorEncontrado = null;
        autorEncontrado = autorService.obtenerPorNombre("fasdfasdf");
        if (autorEncontrado != null){
            log.info(">>> Autor encontrado <<<");
            return autorEncontrado.toString();
        } else {
            log.info(">>> Autor No encontrado <<<");
        }
        return "No se encontro a ese Autor";
    }


}
