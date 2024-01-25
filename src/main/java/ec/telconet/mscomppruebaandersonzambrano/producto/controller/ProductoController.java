package ec.telconet.mscomppruebaandersonzambrano.producto.controller;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.response.ProductoResponse;
import ec.telconet.mscomppruebaandersonzambrano.producto.service.ProductoService;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<OutputEntity<List<ProductoResponse>>> getAll(){
        //Declaramos la respuesta que vamos a devolver
        OutputEntity<List<ProductoResponse>> out = null;
        try{
            // Buscamos la respuesta del service
            out = this.productoService.getlAll();
            //retornamos la data y el código de respuesta del sistema
            return new ResponseEntity<>(out,out.getCode());

        }catch (Exception e){
            //inicializamos el out con un contructor propio de esa clase para enionar error
            out = new OutputEntity<List<ProductoResponse>>().error(500,"Error",null);
            //devolvemos el error
            return new ResponseEntity<>(out,out.getCode());
        }
    }

}
