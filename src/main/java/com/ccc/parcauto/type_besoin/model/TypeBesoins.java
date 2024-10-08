package com.ccc.parcauto.type_besoin.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class TypeBesoins extends AbstractEntity {
    private String lib;
}
