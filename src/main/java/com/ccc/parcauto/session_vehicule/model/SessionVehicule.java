package com.ccc.parcauto.session_vehicule.model;

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
public class SessionVehicule extends AbstractEntity {
    private String typeSession;
    private Date dateSession;
    private String acheteurbeneficiaire;
    private BigInteger montantTransaction;
    private String  etatVehicule;
    private String  observationSession;


    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicules vehicules;

}
