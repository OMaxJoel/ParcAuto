package com.ccc.parcauto.direction.repository;

import com.ccc.parcauto.direction.model.Directions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionsRepository extends JpaRepository<Directions,Long> {

    Directions findByLib(String lib);
}
