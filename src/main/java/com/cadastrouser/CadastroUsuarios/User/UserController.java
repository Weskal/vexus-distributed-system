package com.cadastrouser.CadastroUsuarios.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // List all users
    @GetMapping("/user")
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    // create user
    @PostMapping ("/user")
    public UserModel createUser(@RequestBody UserModel User) {
        return userRepository.save(User);
    }

}
