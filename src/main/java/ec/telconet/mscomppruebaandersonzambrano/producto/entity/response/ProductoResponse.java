package ec.telconet.mscomppruebaandersonzambrano.producto.entity.response;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.ProductoEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoResponse {

    private Long identificador;
    private String nombre;
    private int cantidad;
    private double precio;
    private String imagen;
    private String estado;

    public ProductoResponse(ProductoEntity p){
        this.identificador = p.getId();
        this.nombre = p.getNombre();
        this.cantidad = p.getCantidad();
        this.precio = p.getPrecio();
        this.imagen = p.getImagen();
        this.estado = p.getEstado();
    }
}
