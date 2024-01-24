package ec.telconet.mscomppruebaandersonzambrano.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holamundo")
public class HolaMundoController {

    @GetMapping()
    public String holaMundo(){
        return "Hola Mundo";
    }
}
