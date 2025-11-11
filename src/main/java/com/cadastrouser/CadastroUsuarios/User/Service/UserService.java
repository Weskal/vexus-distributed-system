package com.cadastrouser.CadastroUsuarios.User.Service;

import com.cadastrouser.CadastroUsuarios.Exception.ResourceNotFoundException;
import com.cadastrouser.CadastroUsuarios.User.Model.User;
import com.cadastrouser.CadastroUsuarios.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok — injeta automaticamente o repository via construtor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User usuario) {
        // Aqui você poderia, por exemplo, encriptar senha:
        // usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
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

