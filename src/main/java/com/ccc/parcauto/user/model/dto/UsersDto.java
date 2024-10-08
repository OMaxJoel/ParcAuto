package com.ccc.parcauto.user.model.dto;

import com.ccc.parcauto.profil.model.Profil;
import com.ccc.parcauto.profil.model.dto.ProfilDto;
import com.ccc.parcauto.user.model.Users;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private String password;
    private ProfilDto profil;

    public static UsersDto toDto(Users users)
    {
        return UsersDto.builder()
                .id(users.getId())
                .nom(users.getNom())
                .prenom(users.getPrenom())
                .email(users.getEmail())
                .pseudo(users.getPseudo())
                .password(users.getPassword())
                .profil(ProfilDto.toDto(users.getProfil()))
                .build();
    }

    public static Users toEntity(UsersDto usersDto)
    {
        return Users.builder()
                .id(usersDto.getId())
                .nom(usersDto.getNom())
                .prenom(usersDto.getPrenom())
                .email(usersDto.getEmail())
                .pseudo(usersDto.getPseudo())
                .password(usersDto.getPassword())
                .profil(ProfilDto.toEntity(usersDto.getProfil()))
                .build();
    }
}
