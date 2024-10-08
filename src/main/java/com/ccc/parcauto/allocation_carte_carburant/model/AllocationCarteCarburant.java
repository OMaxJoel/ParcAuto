package com.ccc.parcauto.allocation_carte_carburant.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.carte_carburant.model.CarteCarburant;
import com.ccc.parcauto.conso_carte_carburant.model.ConsoCarteCarburant;
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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class AllocationCarteCarburant extends AbstractEntity {
    private String mois;
    private BigInteger montant;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private CarteCarburant carteCarburant;

    @OneToMany(mappedBy = "allocationCarteCarburant")
    private List<ConsoCarteCarburant> consoCarteCarburants;
}
