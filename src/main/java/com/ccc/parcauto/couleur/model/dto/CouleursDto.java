package com.ccc.parcauto.couleur.model.dto;

import com.ccc.parcauto.couleur.model.Couleurs;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouleursDto {
    private Long id;
    private String lib;

    public static CouleursDto toDto(Couleurs couleurs)
    {
        return CouleursDto.builder()
                .id(couleurs.getId())
                .lib(couleurs.getLib())
                .build();
    }

    public static Couleurs toEntity(CouleursDto couleursDto)
    {
      return Couleurs.builder()
              .id(couleursDto.getId())
              .lib(couleursDto.getLib())
              .build();
    }
}
