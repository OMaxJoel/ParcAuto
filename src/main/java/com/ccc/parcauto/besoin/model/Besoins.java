package com.ccc.parcauto.besoin.model;

import com.ccc.parcauto.Enum.StatutValidation;
import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.detail_besoin.model.DetailBesoins;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.service.model.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Besoins extends AbstractEntity {
    private Date dateDemande;
    private String usagePrincipale;
    private String urgence;
   // private Integer statut_besoin;

    @Enumerated(EnumType.STRING)
    private StatutValidation statutValidation;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;



    @OneToMany(mappedBy = "besoins")
    private List<DetailBesoins> detailBesoins;
}
