package com.ccc.parcauto.besoin.model.dto;

import com.ccc.parcauto.Enum.StatutValidation;
import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.direction.model.dto.DirectionsDto;
import com.ccc.parcauto.service.model.dto.ServicesDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BesoinsDto {
    private Long id;
    private Date dateDemande;
    private String usagePrincipale;
    private String urgence;
    private StatutValidation statutValidation;
    private DirectionsDto directions;
    private ServicesDto services;

    public static BesoinsDto toDto(Besoins besoins)
    {
        return BesoinsDto.builder()
                .id(besoins.getId())
                .dateDemande(besoins.getDateDemande())
                .usagePrincipale(besoins.getUsagePrincipale())
                .urgence(besoins.getUrgence())
                .directions(DirectionsDto.toDto(besoins.getDirections()))
                .services(ServicesDto.toDto(besoins.getServices()))
                .statutValidation(besoins.getStatutValidation())
                .build();
    }

    public static Besoins toEntity(BesoinsDto besoinsDto)
    {
        return Besoins.builder()
                .id(besoinsDto.getId())
                .dateDemande(besoinsDto.getDateDemande())
                .usagePrincipale(besoinsDto.getUsagePrincipale())
                .urgence(besoinsDto.getUrgence())
                .directions(DirectionsDto.toEntity(besoinsDto.getDirections()))
                .services(ServicesDto.toEntity(besoinsDto.getServices()))
                .statutValidation(besoinsDto.getStatutValidation())
                .build();
    }
}
