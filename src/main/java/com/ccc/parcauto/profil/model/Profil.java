package com.ccc.parcauto.profil.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.user.model.Users;
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
public class Profil extends AbstractEntity {
    private String lib;

    @OneToMany(mappedBy = "profil")
    private List<Users> users;
}
