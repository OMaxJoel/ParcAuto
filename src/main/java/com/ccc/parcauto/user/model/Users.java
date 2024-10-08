package com.ccc.parcauto.user.model;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.profil.model.Profil;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Users extends AbstractEntity {
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private String password;

    @ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;
}
