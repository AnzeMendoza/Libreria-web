package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.service.AutorService;
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
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String autores(Model model) {
        try {
            Optional<List<Autor>> autoresOptional = Optional.ofNullable(autorService.findAll());
            model.addAttribute("autores", autoresOptional.get());
            return "views/autores";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/autor/{id}")
    public String autorFormulario(Model model, @PathVariable("id") int id) {
        try {
            if(id==0){
                model.addAttribute("autor", new Autor());
            } else {
                model.addAttribute("autor", autorService.findById(id));
            }
            return "views/form/autor";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/autor/{id}")
    public String autorAlta(Model model, @ModelAttribute("autor") Autor autor, @PathVariable("id") int id){
        try {
            if(id==0){
                autorService.save(autor);
            } else {
                autorService.update(id, autor);
            }
            return "redirect:/autores";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/autor/{id}")
    public String autorEliminar(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("autor", autorService.findById(id));
            return "views/form/eliminarAutor";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/autor/{id}")
    public String autorDesactivar(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("autor", autorService.deleteByIdSoft(id));
            return "redirect:/autores";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
