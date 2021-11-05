package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Prestamo;
import edu.sucho.libreriaweb.service.ClienteService;
import edu.sucho.libreriaweb.service.LibroService;
import edu.sucho.libreriaweb.service.PrestamoService;
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
public class PrestamoController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/prestamos")
    public String prestamos(Model model){
        try{
            Optional<List<Prestamo>> prestamosOptional = Optional.ofNullable(prestamoService.findAll());
            model.addAttribute("prestamos", prestamosOptional.get());
            return "views/prestamos";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/prestamo/{id}")
    public String prestamoFormulario(Model model, @PathVariable("id") int id){
        try{
            model.addAttribute("libros", libroService.findAllByAltaAndInStock());
            model.addAttribute("clientes", clienteService.findAllByAlta());

            if(id==0){
                model.addAttribute("prestamo", new Prestamo());
            } else {
                model.addAttribute("prestamo", prestamoService.findById(id));
            }

            return "views/form/prestamo";
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/prestamo/{id}")
    public String prestamoFormulario(Model model, @PathVariable("id") int id, @ModelAttribute("prestamo") Prestamo prestamo) {
        try {
            if (id == 0) {
                prestamo.setLibro(libroService.substractOneLibro(prestamo.getLibro().getId()));
                prestamoService.save(prestamo);
            } else {
                prestamoService.update(id, prestamo);
            }
            return "redirect:/prestamos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/prestamo/{id}")
    public String prestamoEliminar(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("prestamo", prestamoService.findById(id));
            return "views/form/eliminarPrestamo";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/prestamo/{id}")
    public String prestamoDesactivar(Model model, @PathVariable("id") int id){
        try {
            
            model.addAttribute("prestamo", prestamoService.deleteByIdSoft(id));
            return "redirect:/prestamos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
