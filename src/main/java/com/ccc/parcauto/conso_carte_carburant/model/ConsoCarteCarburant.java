package com.ccc.parcauto.conso_carte_carburant.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.allocation_carte_carburant.model.AllocationCarteCarburant;
import com.ccc.parcauto.carte_carburant.model.CarteCarburant;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class ConsoCarteCarburant extends AbstractEntity {
private BigInteger montantConso;
private Date dateConso;

@ManyToOne
@JoinColumn(name = "carte_id")
private CarteCarburant carteCarburant;

@ManyToOne
@JoinColumn(name = "allocation_id")
private AllocationCarteCarburant allocationCarteCarburant;
}
