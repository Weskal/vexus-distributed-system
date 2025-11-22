package com.cadastrouser.CadastroUsuarios.Controller;

import com.cadastrouser.CadastroUsuarios.Model.User;
import com.cadastrouser.CadastroUsuarios.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // List all users
    @GetMapping ("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usuarios = userService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    // List user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update user by id
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User novosDados) {
        User usuarioAtualizado = userService.updateUser(id, novosDados);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Delete user by id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuário com ID " + id + " foi deletado com sucesso.");
    }

}
