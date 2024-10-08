package com.ccc.parcauto.type_carte.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class TypeCartes extends AbstractEntity {
    private String lib;
}
