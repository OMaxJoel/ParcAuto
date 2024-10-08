package com.ccc.parcauto.type_besoin.model.dto;

import com.ccc.parcauto.type_besoin.model.TypeBesoins;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeBesoinsDto {
    private Long id;
    private String lib;

    public static TypeBesoinsDto toDto(TypeBesoins typeBesoins)
    {
        return TypeBesoinsDto.builder()
                .id(typeBesoins.getId())
                .lib(typeBesoins.getLib())
                .build();
    }

    public static TypeBesoins toEntity(TypeBesoinsDto typeBesoinsDto)
    {
        return TypeBesoins.builder()
                .id(typeBesoinsDto.getId())
                .lib(typeBesoinsDto.getLib())
                .build();
    }
}
