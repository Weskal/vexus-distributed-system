package com.cadastrouser.CadastroUsuarios.User.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Transforma uma classe em uma entidade do BD
@Entity
@Table(name="tb_cadastro_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;
    private String cidade;
    private String estado;
    private int idade;

}
