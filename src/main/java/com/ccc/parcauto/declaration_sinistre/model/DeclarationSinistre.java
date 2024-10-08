package com.ccc.parcauto.declaration_sinistre.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.service.model.Services;
import com.ccc.parcauto.societe_assurance.model.SocieteAssurance;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DeclarationSinistre extends AbstractEntity {
private Date dateSinistre;
private String heure;
private String lieuSinistre;
private String typeSinistre;
private String  descriptionSinistre;
private String  dommageVehicule;
private String  dommageTiers;
private String niveauResponsabilite;
private String numDeclarationAssurance;
private Date dateDeclarationAssurance;
private BigInteger montantReparation;
private BigInteger montantIndemnisation;
private Date dateClotureSinistre;
private Integer statutAssurance;

@ManyToOne
@JoinColumn(name = "direction_id")
private Directions directions;

@ManyToOne
@JoinColumn(name = "service_id")
private Services services;

@ManyToOne
@JoinColumn(name = "cellule_id")
private Cellules cellules;

@ManyToOne
@JoinColumn(name = "societeAssurance_id")
private SocieteAssurance societeAssurance;
}
