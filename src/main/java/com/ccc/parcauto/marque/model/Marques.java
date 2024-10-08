package com.ccc.parcauto.marque.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.vehicule.model.Vehicules;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Marques extends AbstractEntity {
    private String lib;

    @OneToMany(mappedBy = "marques")
    private List<Vehicules> vehicules;
}
