package com.ccc.parcauto.type_duree_location.repository;

import com.ccc.parcauto.type_duree_location.model.TypeDureeLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDureeLocationRepository extends JpaRepository<TypeDureeLocation,Long> {
    TypeDureeLocation findByLib(String lib);
}
