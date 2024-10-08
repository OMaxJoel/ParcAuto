package com.ccc.parcauto.carburant_mission.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.demande_mission.model.DemandeMission;
import com.ccc.parcauto.vehicule.model.Vehicules;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class CarburantMission extends AbstractEntity {
private BigInteger distance;
private BigInteger intraville;
private BigInteger ditanceTotale;
private BigInteger consommationAuCent;
private BigInteger prixCarburant;
private BigInteger totalLitre;
private BigInteger prixTotalCarburant;
private BigInteger peage;
private BigInteger forfaitDistanceRural;
private  BigInteger indForfait;
private BigInteger forfaitJour;

@ManyToOne
@JoinColumn(name = "vehicule_id")
private Vehicules vehicules;

@ManyToOne
@JoinColumn(name = "mission_id")
private DemandeMission demandeMission;
}
