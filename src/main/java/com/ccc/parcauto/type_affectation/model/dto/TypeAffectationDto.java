package com.ccc.parcauto.type_affectation.model.dto;

import com.ccc.parcauto.type_affectation.model.TypeAffectations;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeAffectationDto {
    private Long id;
    private String lib;

    public static TypeAffectationDto toDto(TypeAffectations typeAffectations)
    {
        return TypeAffectationDto.builder()
                .id(typeAffectations.getId())
                .lib(typeAffectations.getLib())
                .build();
    }

    public static TypeAffectations toEntity(TypeAffectationDto typeAffectationDto)
    {
        return TypeAffectations.builder()
                .id(typeAffectationDto.getId())
                .lib(typeAffectationDto.getLib())
                .build();
    }
}
