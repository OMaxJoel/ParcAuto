package com.ccc.parcauto.couleur.repository;

import com.ccc.parcauto.couleur.model.Couleurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleursRepository extends JpaRepository<Couleurs,Long> {
    Couleurs findByLib(String lib);
}
