package com.ccc.parcauto.carte_carburant.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.allocation_carte_carburant.model.AllocationCarteCarburant;
import com.ccc.parcauto.conso_carte_carburant.model.ConsoCarteCarburant;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class CarteCarburant extends AbstractEntity {
    private String familleCarte;
    private String numCarte;
    private Date dateDebut;
    private Date dateFin;
    private boolean statutCarte;

    @OneToMany(mappedBy = "carteCarburant")
    private List<AllocationCarteCarburant> allocationCarteCarburants;

    @OneToMany(mappedBy = "carteCarburant")
    private List<ConsoCarteCarburant> consoCarteCarburants;
}

