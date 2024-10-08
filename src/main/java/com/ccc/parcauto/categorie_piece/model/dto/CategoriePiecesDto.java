package com.ccc.parcauto.categorie_piece.model.dto;

import com.ccc.parcauto.categorie_piece.model.CategoriePieces;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriePiecesDto {
    private Long id;
    private String lib;

    public static CategoriePiecesDto toDto(CategoriePieces categoriePieces)
    {
        return CategoriePiecesDto.builder()
                .id(categoriePieces.getId())
                .lib(categoriePieces.getLib())
                .build();
    }

    public static CategoriePieces toEntity(CategoriePiecesDto categoriePiecesDto)
    {
        return CategoriePieces.builder()
                .id(categoriePiecesDto.getId())
                .lib(categoriePiecesDto.getLib())
                .build();
    }
}
