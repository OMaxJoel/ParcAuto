package com.ccc.parcauto.service.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.affectation.model.Affectations;
import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.declaration_sinistre.model.DeclarationSinistre;
import com.ccc.parcauto.demande_mission.model.DemandeMission;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.intervention.model.Interventions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Services extends AbstractEntity {
    private String lib;

    @OneToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @OneToMany(mappedBy = "services")
    private List<Cellules> cellules;

    @OneToMany(mappedBy = "services")
    private List<Besoins> besoins;

    @OneToMany(mappedBy = "services")
    private List<Affectations> affectations;

    @OneToMany(mappedBy = "services")
    private List<Interventions> interventions;

    @OneToMany(mappedBy = "services")
    private List<DemandeMission> demandeMissions;

    @OneToMany(mappedBy = "services")
    private List<DeclarationSinistre>  declarationSinistres;
}
