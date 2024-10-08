package com.ccc.parcauto.detail_trajet_mission.model;

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

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DetailTrajetMission extends AbstractEntity {
    private String ville_depart;
    private String ville_retour;
    private BigInteger distance;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private DemandeMission demandeMission;
}
