package ec.telconet.mscomppruebaandersonzambrano.producto.service;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.ProductoEntity;
import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.UsuarioEntity;
import ec.telconet.mscomppruebaandersonzambrano.producto.entity.response.ProductoResponse;
import ec.telconet.mscomppruebaandersonzambrano.producto.entity.response.UsuarioResponse;
import ec.telconet.mscomppruebaandersonzambrano.producto.repository.ProductoRepository;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public OutputEntity<List<ProductoResponse>> getlAll(){
        OutputEntity<List<ProductoResponse>> outputEntity = new OutputEntity<>();
        try {
            //Buscamos los datos de la tabla de la bdd
            List<ProductoEntity> productoModelo = this.productoRepository.findAll();
            //Mapeamos los datos con un dto (ProductoResponse)
            List<ProductoResponse> productoResponses = productoModelo.stream().map(
                    p -> new ProductoResponse(p)).collect(Collectors.toList());
            //retornamos la respuesta junto con la cosulta
            return outputEntity.ok(200, "Ok",productoResponses);

        }catch (Exception e){
            return outputEntity.error(500,"Error del sistema", null);
        }
    }

}
