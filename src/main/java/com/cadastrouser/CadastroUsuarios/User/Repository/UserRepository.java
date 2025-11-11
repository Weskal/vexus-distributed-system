package com.cadastrouser.CadastroUsuarios.User.Repository;

import com.cadastrouser.CadastroUsuarios.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
