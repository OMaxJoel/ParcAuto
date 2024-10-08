package com.ccc.parcauto.type_fournisseur.repository;

import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFournisseurRepository extends JpaRepository<TypeFournisseur,Long> {
    TypeFournisseur findByLib(String lib);
}
