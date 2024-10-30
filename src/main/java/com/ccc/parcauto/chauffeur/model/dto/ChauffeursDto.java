package com.ccc.parcauto.chauffeur.model.dto;

import com.ccc.parcauto.chauffeur.model.Chauffeurs;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChauffeursDto {
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String contact;
    private String numPermis;
    private Date dateExpiration;
    private String categoriePermis;
    private boolean statut;

    public static ChauffeursDto toDto(Chauffeurs chauffeurs)
    {
        return ChauffeursDto.builder()
                .id(chauffeurs.getId())
                .matricule(chauffeurs.getMatricule())
                .nom(chauffeurs.getNom())
                .prenom(chauffeurs.getPrenom())
                .contact(chauffeurs.getContact())
                .numPermis(chauffeurs.getNumPermis())
                .dateExpiration(chauffeurs.getDateExpiration())
                .categoriePermis(chauffeurs.getCategoriePermis())
                .statut(chauffeurs.isStatut())
                .build();
    }

    public static Chauffeurs toEntity(ChauffeursDto chauffeursDto)
    {
        return Chauffeurs.builder()
                .id(chauffeursDto.getId())
                .matricule(chauffeursDto.getMatricule())
                .nom(chauffeursDto.getNom())
                .contact(chauffeursDto.getContact())
                .prenom(chauffeursDto.getPrenom())
                .numPermis(chauffeursDto.getNumPermis())
                .dateExpiration(chauffeursDto.getDateExpiration())
                .categoriePermis(chauffeursDto.getCategoriePermis())
                .statut(chauffeursDto.isStatut())
                .build();
    }
}
