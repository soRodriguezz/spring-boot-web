package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class indexController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sebastian");
        usuario.setApellido("Rodriguez");
        usuario.setEmail("sebastian@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "perfil de usuario ".concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Sebastian", "Rodriguez", "sebastian@gmail.com"));
        usuarios.add(new Usuario("Alberto", "Ulloa", "alberto@gmail.com"));
        usuarios.add(new Usuario("Jose", "Cisternas", "jose@gmail.com"));
        return usuarios;
    }
}
