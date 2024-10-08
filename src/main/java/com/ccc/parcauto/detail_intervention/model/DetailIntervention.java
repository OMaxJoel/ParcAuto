package com.ccc.parcauto.detail_intervention.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.intervention.model.Interventions;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DetailIntervention extends AbstractEntity {
    private String lib;
    private BigInteger qte;
    private BigInteger prix_u;
    private BigInteger prix_total;

    @ManyToOne
    @JoinColumn(name = "intervention_id")
    private Interventions interventions;
}
