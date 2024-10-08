package com.ccc.parcauto.type_affectation.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.affectation.model.Affectations;
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
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class TypeAffectations extends AbstractEntity {
    private String lib;

    @OneToMany(mappedBy = "typeAffectations")
    private List<Affectations> affectations;
}
