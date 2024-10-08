package com.ccc.parcauto.type_duree_location.model.dto;

import com.ccc.parcauto.type_duree_location.model.TypeDureeLocation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDureeLocationDto {
    private Long id;
    private String lib;

    public static TypeDureeLocationDto toDto(TypeDureeLocation typeDureeLocation)
    {
        return TypeDureeLocationDto.builder()
                .id(typeDureeLocation.getId())
                .lib(typeDureeLocation.getLib())
                .build();
    }

    public static TypeDureeLocation toEntity(TypeDureeLocationDto typeDureeLocationDto)
    {
        return TypeDureeLocation.builder()
                .id(typeDureeLocationDto.getId())
                .lib(typeDureeLocationDto.getLib())
                .build();
    }
}
