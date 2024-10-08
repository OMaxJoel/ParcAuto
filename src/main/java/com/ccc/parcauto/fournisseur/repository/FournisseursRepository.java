package com.ccc.parcauto.fournisseur.repository;

import com.ccc.parcauto.fournisseur.model.Fournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseursRepository extends JpaRepository<Fournisseurs,Long> {


    Fournisseurs findByNomFournisseur(String nomFournisseur);
}
