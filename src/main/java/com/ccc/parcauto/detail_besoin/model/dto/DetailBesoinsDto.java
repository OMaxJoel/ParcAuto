package com.ccc.parcauto.detail_besoin.model.dto;

import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.besoin.model.dto.BesoinsDto;
import com.ccc.parcauto.detail_besoin.model.DetailBesoins;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailBesoinsDto {
    private Long id;
    private String description;
    private BigInteger qte;
    private BigInteger prix_u;
    private BigInteger totalBesoins;
    private BesoinsDto besoins;

    public static DetailBesoinsDto toDto(DetailBesoins detailBesoins)
    {
        return DetailBesoinsDto.builder()
                .id(detailBesoins.getId())
                .description(detailBesoins.getDescription())
                .qte(detailBesoins.getQte())
                .prix_u(detailBesoins.getPrix_u())
                .totalBesoins(detailBesoins.getTotalBesoins())
                .besoins(BesoinsDto.toDto(detailBesoins.getBesoins()))
                .build();
    }

    public static DetailBesoins toEntity(DetailBesoinsDto detailBesoinsDto)
    {
        return DetailBesoins.builder()
                .id(detailBesoinsDto.getId())
                .description(detailBesoinsDto.getDescription())
                .qte(detailBesoinsDto.getQte())
                .prix_u(detailBesoinsDto.getPrix_u())
                .totalBesoins(detailBesoinsDto.getTotalBesoins())
                .besoins(BesoinsDto.toEntity(detailBesoinsDto.getBesoins()))
                .build();
    }
}
