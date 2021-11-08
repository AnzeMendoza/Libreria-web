package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Editorial;
import edu.sucho.libreriaweb.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/editoriales")
    public String editorialesCrud(Model model) {
        try {
            Optional<List<Editorial>> editorialesOptional = Optional.ofNullable(editorialService.findAll());
            model.addAttribute("editoriales", editorialesOptional.get());
            return "views/editoriales";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/editorial/{id}")
    public String editorialFormulario(Model model, @PathVariable("id") int id) {
        try {
            if (id == 0) {
                model.addAttribute("editorial", new Editorial());
            } else {
                model.addAttribute("editorial", editorialService.findById(id));
            }
            return "views/form/editorial";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/editorial/{id}")
    public String editorialAlta(Model model,
                                @Valid @ModelAttribute("editorial") Editorial editorial,
                                BindingResult result,
                                @PathVariable("id") int id) {
        try {

            if(result.hasErrors()){
                return "views/form/editorial";
            }

            if (id == 0) {
                editorialService.save(editorial);
            } else {
                editorialService.update(id, editorial);
            }
            return "redirect:/editoriales";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/editorial/{id}")
    public String autorEliminar(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("editorial", editorialService.findById(id));
            return "views/form/eliminarEditorial";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/editorial/{id}")
    public String autorDesactivar(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("editorial", editorialService.deleteByIdSoft(id));
            return "redirect:/editoriales";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
