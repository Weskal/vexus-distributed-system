package com.cadastrouser.CadastroUsuarios.User.Controller;

import com.cadastrouser.CadastroUsuarios.Exception.ResourceNotFoundException;
import com.cadastrouser.CadastroUsuarios.User.Model.User;
import com.cadastrouser.CadastroUsuarios.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userapi")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // List all users
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // create user = 201
    @PostMapping ("/user")
    public ResponseEntity<User> createUser(@RequestBody User usuario) {
        User novoUsuario = userRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // List user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        return ResponseEntity.ok(usuario);
    }

    // Update user by id
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User dadosAtualizados) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        usuario.setNome(dadosAtualizados.getNome());
        usuario.setEmail(dadosAtualizados.getEmail());
        usuario.setPassword(dadosAtualizados.getPassword());
        usuario.setCidade(dadosAtualizados.getCidade());
        usuario.setEstado(dadosAtualizados.getEstado());
        usuario.setIdade(dadosAtualizados.getIdade());

        User usuarioAtualizado = userRepository.save(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Delete user by id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User>  deleteUserById(@PathVariable Long id) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        userRepository.delete(usuario);
        return ResponseEntity.ok(usuario);

    }

}
