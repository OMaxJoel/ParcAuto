package com.ccc.parcauto.detail_piece.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.categorie_piece.model.CategoriePieces;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class DetailPieces extends AbstractEntity {
    private String lib;

    @ManyToOne
    @JoinColumn(name = "categoriepiece_id")
    private CategoriePieces categoriePieces;
}
