package edu.sucho.libreriaweb.controller;

import edu.sucho.libreriaweb.model.Cliente;
import edu.sucho.libreriaweb.service.ClienteService;
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
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        try {
            Optional<List<Cliente>> clientesOptional = Optional.ofNullable(clienteService.findAll());
            model.addAttribute("clientes", clientesOptional.get());
            return "views/clientes";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/cliente/{id}")
    public String clienteFormulario(Model model, @PathVariable("id") int id) {
        try {
            if (id == 0) {
                model.addAttribute("cliente", new Cliente());
            } else {
                Optional<Cliente> clienteOptional = Optional.ofNullable(clienteService.findById(id));
                model.addAttribute("cliente", clienteOptional.get());
            }
            return "views/form/cliente";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/cliente/{id}")
    public String clienteFormulario(Model model, @PathVariable("id") int id, @ModelAttribute("cliente") Cliente cliente) {
        try {
            if (id == 0) {
                clienteService.save(cliente);
            } else {
                clienteService.update(id, cliente);
            }
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/cliente/{id}")
    public String clienteEliminar(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("cliente", clienteService.findById(id));
            return "views/form/eliminarCliente";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/cliente/{id}")
    public String ClienteDesactivar(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("cliente", clienteService.deleteByIdSoft(id));
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
