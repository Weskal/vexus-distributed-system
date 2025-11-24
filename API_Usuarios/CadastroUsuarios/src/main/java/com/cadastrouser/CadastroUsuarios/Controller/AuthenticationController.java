package com.cadastrouser.CadastroUsuarios.Controller;

import com.cadastrouser.CadastroUsuarios.Model.User;
import com.cadastrouser.CadastroUsuarios.Service.UserService;
import com.cadastrouser.CadastroUsuarios.User.AuthenticationDTO;
import com.cadastrouser.CadastroUsuarios.User.LoginResponseDTO;
import com.cadastrouser.CadastroUsuarios.User.RegisterDTO;
import com.cadastrouser.CadastroUsuarios.infra.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private final UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // Create user = 201
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody RegisterDTO dto) {
        User novoUsuario = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
