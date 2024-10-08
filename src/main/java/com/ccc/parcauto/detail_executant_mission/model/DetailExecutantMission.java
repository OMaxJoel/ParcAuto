package com.ccc.parcauto.detail_executant_mission.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.demande_mission.model.DemandeMission;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DetailExecutantMission extends AbstractEntity {
private String matricule;
private String nom;
private String prenom;

@ManyToOne
@JoinColumn(name = "mission_id")
private DemandeMission demandeMission;
}
