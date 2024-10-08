package com.ccc.parcauto.service.model.dto;

import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.direction.model.dto.DirectionsDto;
import com.ccc.parcauto.service.model.Services;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicesDto {
    private Long id;
    private String lib;
    private DirectionsDto directions;

    public static ServicesDto toDto(Services services)
    {
        return ServicesDto.builder()
                .id(services.getId())
                .lib(services.getLib())
                .directions(DirectionsDto.toDto(services.getDirections()))
                .build();
    }

    public static Services toEntity(ServicesDto services)
    {
        return Services.builder()
                .id(services.getId())
                .lib(services.getLib())
                .directions(DirectionsDto.toEntity(services.getDirections()))
                .build();
    }
}
