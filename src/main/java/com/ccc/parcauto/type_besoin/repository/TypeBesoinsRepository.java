package com.ccc.parcauto.type_besoin.repository;

import com.ccc.parcauto.type_besoin.model.TypeBesoins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeBesoinsRepository extends JpaRepository<TypeBesoins,Long> {
    TypeBesoins findByLib(String lib);
}
