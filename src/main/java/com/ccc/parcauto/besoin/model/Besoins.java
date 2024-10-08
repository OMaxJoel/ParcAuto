package com.ccc.parcauto.besoin.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.cellule.model.Cellules;
import com.ccc.parcauto.detail_besoin.model.DetailBesoins;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.service.model.Services;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Besoins extends AbstractEntity {
    private Date date_demande;
    private String usage_principale;
    private String urgence;
    private Integer statut_besoin;

    @ManyToOne
    @JoinColumn(name = "cellule_id")
    private Cellules cellules;

    @ManyToOne
    @JoinColumn(name = "servvice_id")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @OneToMany(mappedBy = "besoins")
    private List<DetailBesoins> detailBesoins;
}
