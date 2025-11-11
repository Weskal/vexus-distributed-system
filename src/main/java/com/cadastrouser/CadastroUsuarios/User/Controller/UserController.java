package com.cadastrouser.CadastroUsuarios.User.Controller;

import com.cadastrouser.CadastroUsuarios.Exception.ResourceNotFoundException;
import com.cadastrouser.CadastroUsuarios.User.Model.User;
import com.cadastrouser.CadastroUsuarios.User.Repository.UserRepository;
import com.cadastrouser.CadastroUsuarios.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // List all users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usuarios = userService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    // Create user = 201
    @PostMapping ("/")
    public ResponseEntity<User> createUser(@RequestBody User usuario) {
        User novoUsuario = userService.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // List user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update user by id
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User novosDados) {
        User usuarioAtualizado = userService.updateUser(id, novosDados);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuário com ID " + id + " foi deletado com sucesso.");
    }

}
