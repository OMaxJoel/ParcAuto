package com.ccc.parcauto.cellule.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.affectation.model.Affectations;
import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.declaration_sinistre.model.DeclarationSinistre;
import com.ccc.parcauto.demande_mission.model.DemandeMission;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.intervention.model.Interventions;
import com.ccc.parcauto.service.model.Services;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Cellules extends AbstractEntity {
    private String lib;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @OneToMany(mappedBy = "cellules")
    private List<Affectations> affectations;

    @OneToMany(mappedBy = "cellules")
    private List<Interventions> interventions;

    @OneToMany(mappedBy = "cellules")
    private List<DemandeMission> demandeMissions;

    @OneToMany(mappedBy = "cellules")
    private List<DeclarationSinistre>  declarationSinistres;


}
