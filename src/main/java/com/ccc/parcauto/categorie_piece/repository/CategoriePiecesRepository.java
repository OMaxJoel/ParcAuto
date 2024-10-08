package com.ccc.parcauto.categorie_piece.repository;

import com.ccc.parcauto.categorie_piece.model.CategoriePieces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriePiecesRepository extends JpaRepository<CategoriePieces,Long> {
    CategoriePieces findByLib(String lib);
}
