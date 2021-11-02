package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Libro;
import edu.sucho.libreriaweb.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class LibroController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String index(Model model) {
        try{
            List<Libro> librosActivos = libroService.findAllByAlta();
            System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<");
            System.out.println(librosActivos);
            System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<");
            model.addAttribute("librosActivos", librosActivos);
            return "index";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/libros")
    public String librosCrud(Model model){
        try{
            Optional<List<Libro>> librosOptional = Optional.ofNullable(libroService.findAll());
            model.addAttribute("libros", librosOptional.get());
            return "views/libros";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/libro/{id}")
    public String libroFormulario(Model model, @PathVariable("id") int id){
        try{
            model.addAttribute("autores", autorService.findAll());
            model.addAttribute("editoriales", editorialService.findAll());

            if(id==0){
                model.addAttribute("libro", new Libro());
            } else {
                model.addAttribute("libro", libroService.findById(id));
            }
            return "views/form/libro";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/libro/{id}")
    public String libroAlta(@ModelAttribute("libro") Libro libro, Model model, @PathVariable("id") int id){
        try {
            if(id==0){
                libroService.save(libro);
            } else {
                libroService.update(id, libro);
            }
            return "redirect:/libros";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/libro/{id}")
    public String eliminarLibro(Model model, @PathVariable("id") int id){
        try{
            model.addAttribute("libro", libroService.findById(id));
            return "views/form/eliminarLibro";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/libro/{id}")
    public String desactivarLibro(Model model, @PathVariable("id") int id){
        try {
            libroService.deleteByIdSoft(id);
            return "redirect:/libros";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
