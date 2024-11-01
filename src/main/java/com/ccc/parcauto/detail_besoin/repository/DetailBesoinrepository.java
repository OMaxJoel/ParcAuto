package com.ccc.parcauto.detail_besoin.repository;

import com.ccc.parcauto.detail_besoin.model.DetailBesoins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailBesoinrepository extends JpaRepository<DetailBesoins,Long> {
    DetailBesoins findByDescription(String description);
}
