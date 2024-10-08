package com.ccc.parcauto.chauffeur.repository;

import com.ccc.parcauto.chauffeur.model.Chauffeurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeursRepository extends JpaRepository<Chauffeurs,Long> {
    Chauffeurs findByMatricule(String matricule);
}
