package com.ccc.parcauto.user.repository;

import com.ccc.parcauto.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByPseudo(String pseudo);
}
