package com.ccc.parcauto.detail_piece.model.dto;

import com.ccc.parcauto.categorie_piece.model.dto.CategoriePiecesDto;
import com.ccc.parcauto.detail_piece.model.DetailPieces;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailPiecesDto {
    private Long id;
    private String lib;
    private CategoriePiecesDto categoriePieces;

    public static DetailPiecesDto toDto(DetailPieces detailPieces)
    {
        return DetailPiecesDto.builder()
                .id(detailPieces.getId())
                .lib(detailPieces.getLib())
                .categoriePieces(CategoriePiecesDto.toDto(detailPieces.getCategoriePieces()))
                .build();
    }

    public static DetailPieces toEntity(DetailPiecesDto detailPiecesDto)
    {
        return DetailPieces.builder()
                .id(detailPiecesDto.getId())
                .lib(detailPiecesDto.getLib())
                .categoriePieces(CategoriePiecesDto.toEntity(detailPiecesDto.getCategoriePieces()))
                .build();
    }
}
