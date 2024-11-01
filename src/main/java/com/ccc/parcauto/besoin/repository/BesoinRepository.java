package com.ccc.parcauto.besoin.repository;

import com.ccc.parcauto.besoin.model.Besoins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BesoinRepository extends JpaRepository<Besoins,Long> {
    Besoins findByusagePrincipale(String usagePrincipale);
}
