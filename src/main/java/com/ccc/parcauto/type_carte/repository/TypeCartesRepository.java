package com.ccc.parcauto.type_carte.repository;

import com.ccc.parcauto.type_carte.model.TypeCartes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCartesRepository extends JpaRepository<TypeCartes,Long> {
    TypeCartes findByLib(String lib);
}
