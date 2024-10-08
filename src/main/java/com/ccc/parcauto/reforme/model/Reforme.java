package com.ccc.parcauto.reforme.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
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

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Reforme extends AbstractEntity {
    private Date dateReforme;
    private String  motifReforme;
    private BigInteger valeurReforme;
    private String  procedureReforme;
    private String  observationReforme;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicules vehicules;
}
