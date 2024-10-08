package com.ccc.parcauto.marque.repository;

import com.ccc.parcauto.marque.model.Marques;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarquesRepository extends JpaRepository<Marques,Long> {
    Marques findByLib(String lib);
}
