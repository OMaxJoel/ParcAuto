package com.ccc.parcauto.profil.model.dto;

import com.ccc.parcauto.profil.model.Profil;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfilDto {
    private Long id;
    private String lib;

    public static ProfilDto toDto(Profil profil)
    {
        return ProfilDto.builder()
                .id(profil.getId())
                .lib(profil.getLib())
                .build();
    }

    public static Profil toEntity(ProfilDto profilDto)
    {
        return Profil.builder()
                .id(profilDto.getId())
                .lib(profilDto.getLib())
                .build();
    }
}
