package com.ccc.parcauto.detail_piece.repository;

import com.ccc.parcauto.detail_piece.model.DetailPieces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailPiecesRepository extends JpaRepository<DetailPieces,Long> {
    DetailPieces findByLib(String lib);
}
