package com.ccc.parcauto.societe_assurance.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.declaration_sinistre.model.DeclarationSinistre;
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
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class SocieteAssurance extends AbstractEntity {
    private String nom_assurance;
    private String pays;
    private String situation_geo;
    private  String telephone;
    private String email;
    private String nom_contact;
    private String telephone_contact;
    private String email_contact;
    private boolean statut;

    @OneToMany(mappedBy = "societeAssurance")
    private List<DeclarationSinistre> declarationSinistres;
}
