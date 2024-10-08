package com.ccc.parcauto.marque.model.dto;

import com.ccc.parcauto.marque.model.Marques;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarquesDto {
    private long id;
    private String lib;

    public static MarquesDto toDto(Marques marques)
    {
        return MarquesDto.builder()
                .id(marques.getId())
                .lib(marques.getLib())
                .build();
    }

    public static Marques toEntity(MarquesDto marquesDto)
    {
        return Marques.builder()
                .id(marquesDto.getId())
                .lib(marquesDto.getLib())
                .build();
    }
}
