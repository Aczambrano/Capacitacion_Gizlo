package ec.telconet.mscomppruebaandersonzambrano.producto.controller;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.response.UsuarioResponse;
import ec.telconet.mscomppruebaandersonzambrano.producto.service.UsuarioService;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping()
    public ResponseEntity<OutputEntity<List<UsuarioResponse>>> getAll(){
        OutputEntity <List<UsuarioResponse>> out = null;
        try{
            out = this.usuarioService.getAll();
            return new ResponseEntity<>(out,out.getCode());
        }catch (Exception e){
            out = new OutputEntity<List<UsuarioResponse>>().error(500, "Error", null);
            return new ResponseEntity<>(out, out.getCode());
        }
    }
}
