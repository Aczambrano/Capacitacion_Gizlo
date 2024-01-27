package ec.telconet.mscomppruebaandersonzambrano.security.service;

import ec.telconet.mscomppruebaandersonzambrano.main.entity.models.UsuarioEntity;
import ec.telconet.mscomppruebaandersonzambrano.main.entity.response.UsuarioResponse;
import ec.telconet.mscomppruebaandersonzambrano.main.repository.UsuarioRepository;
import ec.telconet.mscomppruebaandersonzambrano.security.entity.LoginRequest;
import ec.telconet.mscomppruebaandersonzambrano.security.response.LoginResponse;
import ec.telconet.mscomppruebaandersonzambrano.util.Exception.MyException;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import ec.telconet.mscomppruebaandersonzambrano.util.enums.MessageEnum;
import ec.telconet.mscomppruebaandersonzambrano.util.helper.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenHelper tokenHelper;

    public OutputEntity<LoginResponse> login(LoginRequest data){
        OutputEntity<LoginResponse> output = new OutputEntity<>();
        try{
            LoginResponse loginResponse = new LoginResponse();
            UsuarioEntity usuario = this.usuarioRepository.findByUserLogin(data.getUsuario());
            if(usuario ==null){
                throw new MyException(MessageEnum.NOT_FOUND.getCode(), MessageEnum.NOT_FOUND.getMensaje());
            }

            UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);

            loginResponse.setUsuarioResponse(usuarioResponse);
            loginResponse.setToken(this.tokenHelper.generateToken(data.getUsuario(),usuarioResponse,"clave123"));
            return output.ok(MessageEnum.OK.getCode(), MessageEnum.OK.getMensaje(), loginResponse);
        }catch (MyException e){
            return output.error(e.getCode(), e.getMensaje(),null);
        }catch (Exception e){
            return output.error();
        }

    }
}
