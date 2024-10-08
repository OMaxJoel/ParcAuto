package com.ccc.parcauto.direction.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.affectation.model.Affectations;
import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.declaration_sinistre.model.DeclarationSinistre;
import com.ccc.parcauto.demande_mission.model.DemandeMission;
import com.ccc.parcauto.intervention.model.Interventions;
import com.ccc.parcauto.service.model.Services;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Directions extends AbstractEntity {

    private String lib;

    @OneToMany(mappedBy = "directions")
    private List<Services> services;

    @OneToMany(mappedBy = "directions")
    private List<Cellules> cellules;

    @OneToMany(mappedBy = "directions")
    private List<Besoins> besoins;

    @OneToMany(mappedBy = "directions")
    private List<Affectations> affectations;

    @OneToMany(mappedBy = "directions")
    private List<Interventions> interventions;

    @OneToMany(mappedBy = "directions")
    private List<DemandeMission> demandeMissions;

    @OneToMany(mappedBy = "directions")
    private List<DeclarationSinistre>  declarationSinistres;
}
