package com.ccc.parcauto.intervention.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.detail_intervention.model.DetailIntervention;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.garage.model.Garage;
import com.ccc.parcauto.service.model.Services;
import com.ccc.parcauto.vehicule.model.Vehicules;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Interventions extends AbstractEntity {
    private String typeIntervention;
    private String gravite;
    private String urgence;
    private Date dateDemande;
    private String  natureProbleme;
    private String  pieceFacture;
    private Integer statutDemande;

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
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @OneToMany(mappedBy = "interventions")
    private List<DetailIntervention> detailInterventions;


}
