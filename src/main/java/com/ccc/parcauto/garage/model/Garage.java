package com.ccc.parcauto.garage.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.intervention.model.Interventions;
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
public class Garage extends AbstractEntity {
    private String nom_garage;
    private String pays;
    private String situation_geo;
    private  String telephone;
    private String email;
    private String nom_contact;
    private String telephone_contact;
    private String email_contact;
    private boolean statut;

    @OneToMany(mappedBy = "garage")
    private List<Interventions> interventions;
}
