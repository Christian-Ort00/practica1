package practica.arboles.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practica.arboles.domain.Arbol;
import practica.arboles.service.ArbolService;

@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;


    @GetMapping("/listado")
    public String inicio(Model model) {
        var arboles = arbolService.getArboles();
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        model.addAttribute("arbol", new Arbol()); 
        return "/arbol/listado";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminaArbol(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }


    @GetMapping("/modificar/{id}")
    public String modificaArbol(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }


    @PostMapping("/guardar")
    public String guardaArbol(Arbol arbol) {
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
}
