package com.ccc.parcauto.type_carte.model.dto;

import com.ccc.parcauto.type_carte.model.TypeCartes;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypesCartesDto {
    private Long id;
    private String lib;

    public static TypesCartesDto toDto(TypeCartes typeCartes)
    {
        return TypesCartesDto.builder()
                .id(typeCartes.getId())
                .lib(typeCartes.getLib())
                .build();
    }

    public static TypeCartes toEntity(TypesCartesDto typesCartesDto)
    {
        return TypeCartes.builder()
                .id(typesCartesDto.getId())
                .lib(typesCartesDto.getLib())
                .build();
    }
}
