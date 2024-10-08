package com.ccc.parcauto.detail_besoin.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.besoin.model.Besoins;
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
public class DetailBesoins extends AbstractEntity {
private String description;
private Integer qte;
private BigInteger prix_u;
private BigInteger totalBesoins;

@ManyToOne
@JoinColumn(name = "besoin_id")
private Besoins besoins;
}
