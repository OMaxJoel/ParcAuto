package com.ccc.parcauto.type_affectation.repository;

import com.ccc.parcauto.type_affectation.model.TypeAffectations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAffectationRepository extends JpaRepository<TypeAffectations,Long> {
    TypeAffectations findByLib(String lib);
}
