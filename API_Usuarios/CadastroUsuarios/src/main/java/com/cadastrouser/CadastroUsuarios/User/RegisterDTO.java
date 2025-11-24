package com.cadastrouser.CadastroUsuarios.User;

public record RegisterDTO(
        String nome,
        String email,
        String password,
        String cidade,
        String estado,
        int idade
) {
}
