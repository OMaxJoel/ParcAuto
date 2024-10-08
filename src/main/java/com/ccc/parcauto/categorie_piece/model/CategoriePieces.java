package com.ccc.parcauto.categorie_piece.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.detail_piece.model.DetailPieces;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class CategoriePieces extends AbstractEntity {
    private String lib;

    @OneToMany(mappedBy = "categoriePieces")
    private List<DetailPieces> detailPieces;
}
