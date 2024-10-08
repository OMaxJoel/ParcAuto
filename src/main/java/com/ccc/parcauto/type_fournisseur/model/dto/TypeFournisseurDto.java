package com.ccc.parcauto.type_fournisseur.model.dto;

import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeFournisseurDto {
    private Long id;
    private String lib;

    public static TypeFournisseurDto toDto(TypeFournisseur typeFournisseur)
    {
        return TypeFournisseurDto.builder()
                .id(typeFournisseur.getId())
                .lib(typeFournisseur.getLib())
                .build();
    }

    public static TypeFournisseur toEntity(TypeFournisseurDto typeFournisseurDto)
    {
        return TypeFournisseur.builder()
                .id(typeFournisseurDto.getId())
                .lib(typeFournisseurDto.getLib())
                .build();
    }
}
