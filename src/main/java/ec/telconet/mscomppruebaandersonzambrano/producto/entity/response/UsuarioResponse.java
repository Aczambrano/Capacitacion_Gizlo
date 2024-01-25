package ec.telconet.mscomppruebaandersonzambrano.producto.entity.response;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.UsuarioEntity;
import lombok.Data;

@Data

public class UsuarioResponse {

    private Long identificador;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String usuario;
    private String correo;
    private String estado;
    private Boolean administrador;


    public UsuarioResponse(UsuarioEntity u) {
        this.identificador = u.getId();
        this.nombreUsuario = u.getNombre();
        this.apellidoUsuario = u.getApellido();
        this.usuario = u.getUsuario();
        this.correo = u.getEmail();
        this.administrador = u.getAdmin();

        switch ( u.getEstado().toString().toLowerCase()){
            case "a":
                this.estado = "Activo";
                break;
            case "e":
                this.estado = "Eliminado";
                break;
            case "i":
                this.estado = "Inactivo";
                break;
        }
    }

}
