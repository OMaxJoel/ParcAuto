package com.ccc.parcauto.rebus.model;

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

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Rebus extends AbstractEntity {
    private Date dateRebus;
    private String  motifRebus;
    private String  etatVehicule;
    private String  decisionrebus;
    private String  observationRebus;
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicules vehicules;
}
