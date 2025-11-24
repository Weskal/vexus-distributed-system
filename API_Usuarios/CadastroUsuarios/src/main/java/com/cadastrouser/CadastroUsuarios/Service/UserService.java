package com.cadastrouser.CadastroUsuarios.Service;

import com.cadastrouser.CadastroUsuarios.Exception.ResourceNotFoundException;
import com.cadastrouser.CadastroUsuarios.Model.User;
import com.cadastrouser.CadastroUsuarios.Repository.UserRepository;
import com.cadastrouser.CadastroUsuarios.User.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok — injeta automaticamente o repository via construtor
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(RegisterDTO dto) {

        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Already registred email!");
        }

        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password())); // IMPORTANTE: criptografar!
        user.setCidade(dto.cidade());
        user.setEstado(dto.estado());
        user.setIdade(dto.idade());

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public User updateUser(Long id, User novosDados) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        usuario.setNome(novosDados.getNome());
        usuario.setEmail(novosDados.getEmail());
        usuario.setPassword(novosDados.getPassword());
        usuario.setCidade(novosDados.getCidade());
        usuario.setEstado(novosDados.getEstado());
        usuario.setIdade(novosDados.getIdade());

        return userRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        userRepository.delete(usuario);
    }

}

