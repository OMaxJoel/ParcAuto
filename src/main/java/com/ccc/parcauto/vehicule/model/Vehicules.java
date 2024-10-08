package com.ccc.parcauto.vehicule.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.affectation.model.Affectations;
import com.ccc.parcauto.carburant_mission.model.CarburantMission;
import com.ccc.parcauto.intervention.model.Interventions;
import com.ccc.parcauto.marque.model.Marques;
import com.ccc.parcauto.rebus.model.Rebus;
import com.ccc.parcauto.reforme.model.Reforme;
import com.ccc.parcauto.session_vehicule.model.SessionVehicule;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Vehicules extends AbstractEntity {
    private String immatriculationProv;
    private Date dateProvisoire;
    private String immatriculationDef;
    private Date dateImmaDefinitive;
    private String modele;
    private BigInteger annee;
    private  String num_chassis;
    private String typeCarburant;
    private BigInteger consommationAuCent;
    private BigInteger capaciteReservoir;
    private BigInteger coutAcquisition;
    private Date dateAcquisition;
    private  boolean statutVehicule;
    private boolean statutAffectation;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marques marques;

    @OneToMany(mappedBy = "vehicules")
    private List<Affectations> affectations;

    @OneToMany(mappedBy = "vehicules")
    private List<Interventions> interventions;

    @OneToMany(mappedBy = "vehicules")
    private List<CarburantMission> carburantMissions;

    @OneToMany(mappedBy = "vehicules")
    private List<Rebus> rebus;

    @OneToMany(mappedBy = "vehicules")
    private List<Reforme> reformes;

    @OneToMany(mappedBy = "vehicules")
    private List<SessionVehicule> sessionVehicules;

}
