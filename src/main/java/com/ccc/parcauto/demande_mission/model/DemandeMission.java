package com.ccc.parcauto.demande_mission.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.carburant_mission.model.CarburantMission;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.detail_executant_mission.model.DetailExecutantMission;
import com.ccc.parcauto.detail_trajet_mission.model.DetailTrajetMission;
import com.ccc.parcauto.direction.model.Directions;
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
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DemandeMission extends AbstractEntity {
    private String matricule;
    private String nom;
    private String prenom;
    private String fonction;
    private String lieuFonction;
    private String interet;
    private Date dateDepart;
    private Date dateRetour;
    private String  imputation;
    private Date dateDemande;
    private Date dateValidation;
    private boolean statutDemande;


    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "cellule_id")
    private Cellules cellules;

    @OneToMany(mappedBy = "demandeMission")
    private List<DetailExecutantMission> detailExecutantMissions;

    @OneToMany(mappedBy = "demandeMission")
    private List<DetailTrajetMission> detailTrajetMissions;

    @OneToMany(mappedBy = "demandeMission")
    private List<CarburantMission> carburantMissions;




}
