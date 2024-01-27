package ec.telconet.mscomppruebaandersonzambrano.security.controller;

import ec.telconet.mscomppruebaandersonzambrano.security.entity.LoginRequest;
import ec.telconet.mscomppruebaandersonzambrano.security.response.LoginResponse;
import ec.telconet.mscomppruebaandersonzambrano.security.service.LoginService;
import ec.telconet.mscomppruebaandersonzambrano.util.entities.OutputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public ResponseEntity<OutputEntity<LoginResponse>> login(@RequestBody LoginRequest data){

        OutputEntity<LoginResponse> out = null;

        try {
            out = this.loginService.login(data);
            return new ResponseEntity<>(out,out.getCode());
        }catch (Exception e){
            out = new OutputEntity<LoginResponse>().error();
            return new ResponseEntity<>(out, out.getCode());
        }


    }


}
