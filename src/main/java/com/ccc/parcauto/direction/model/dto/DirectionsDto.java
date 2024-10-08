package com.ccc.parcauto.direction.model.dto;

import com.ccc.parcauto.direction.model.Directions;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectionsDto {
    private Long id;
    private String lib;

    public static DirectionsDto toDto(Directions directions)
    {
        return DirectionsDto.builder()
                .id(directions.getId())
                .lib(directions.getLib())
                .build();
    }
    public static Directions toEntity(DirectionsDto directions)
    {
        return Directions.builder()
                .id(directions.getId())
                .lib(directions.getLib())
                .build();
    }


}
