package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/prestamos")
    public String prestamos(Model model){
        try{
            return "views/prestamos";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
