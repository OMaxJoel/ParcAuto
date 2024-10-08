package com.ccc.parcauto.chauffeur.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Chauffeurs extends AbstractEntity {
private String matricule;
private String nom;
private String prenom;
private String contact;
private String numPermis;
private Date dateExpiration;
private String categoriePermis;
private boolean statut;
}
