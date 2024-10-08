package com.ccc.parcauto.fournisseur.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
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
public class Fournisseurs extends AbstractEntity {
private String nomFournisseur;
private String pays;
private String situationGeo;
private  String telephone;
private String email;
private String nomContact;
private String telephoneContact;
private String emailContact;
private boolean statut;

@ManyToOne
    @JoinColumn(name = "id_typeFournisseur")
    private TypeFournisseur typeFournisseur;
}
