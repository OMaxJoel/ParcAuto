package com.ccc.parcauto.service.repository;

import com.ccc.parcauto.service.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services,Long> {
    Services findByLib(String lib);
}
