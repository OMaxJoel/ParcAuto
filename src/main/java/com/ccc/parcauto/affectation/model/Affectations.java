package com.ccc.parcauto.affectation.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.service.model.Services;
import com.ccc.parcauto.type_affectation.model.TypeAffectations;
import com.ccc.parcauto.vehicule.model.Vehicules;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.w3c.dom.Text;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Affectations extends AbstractEntity {
    private Date dateAffectation;
    private Date dateFinAffectation;
    private String usagePrincipal;
    private boolean statutAffectation;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicules vehicules;

    @ManyToOne
    @JoinColumn(name = "cellule_id")
    private Cellules cellules;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @ManyToOne
    @JoinColumn(name = "typeAffectation_id")
    private TypeAffectations typeAffectations;
}
