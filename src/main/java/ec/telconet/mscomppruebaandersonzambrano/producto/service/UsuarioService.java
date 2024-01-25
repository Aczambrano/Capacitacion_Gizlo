package ec.telconet.mscomppruebaandersonzambrano.producto.service;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.UsuarioEntity;
import ec.telconet.mscomppruebaandersonzambrano.producto.entity.response.UsuarioResponse;
import ec.telconet.mscomppruebaandersonzambrano.producto.repository.UsuarioRepository;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public OutputEntity<List<UsuarioResponse>> getAll() {
        OutputEntity<List<UsuarioResponse>> outPut = new OutputEntity<>();
        try {
            List<UsuarioEntity> usuarioModelo = this.usuarioRepository.findAll();

            List<UsuarioResponse> usuarioResponses = usuarioModelo.stream().map(u ->
                    new UsuarioResponse(u)).collect(Collectors.toList());

            return outPut.ok(200, "Ok", usuarioResponses);
        } catch (Exception e) {
            return outPut.error(500, "Error de Sistema", null);
        }
    }

}
