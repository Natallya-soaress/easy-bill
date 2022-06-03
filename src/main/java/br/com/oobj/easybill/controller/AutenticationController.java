package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.LoginRequest;
import br.com.oobj.easybill.dto.TokenResponse;
import br.com.oobj.easybill.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticationController {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid LoginRequest login){
        UsernamePasswordAuthenticationToken informations = login.toConvert();

        try {
            Authentication authenticate = authenticationManager.authenticate(informations);

            String token = tokenService.generateToken(authenticate);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));

        } catch ( AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
