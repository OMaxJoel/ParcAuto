package com.ccc.parcauto.profil.repository;

import com.ccc.parcauto.profil.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository<Profil,Long> {
    Profil findByLib(String lib);
}
