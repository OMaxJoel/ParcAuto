package com.ccc.parcauto.type_fournisseur.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.fournisseur.model.Fournisseurs;
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
public class TypeFournisseur extends AbstractEntity {
    private String lib;

    @OneToMany(mappedBy = "typeFournisseur")
    private List<Fournisseurs> fournisseurs;
}
