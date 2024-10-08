package com.ccc.parcauto.user.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.profil.model.Profil;
import com.ccc.parcauto.profil.repository.ProfilRepository;
import com.ccc.parcauto.user.model.Users;
import com.ccc.parcauto.user.model.dto.UsersDto;
import com.ccc.parcauto.user.repository.UsersRepository;
import com.ccc.parcauto.user.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository repository;
    @Autowired
    ProfilRepository profilRepository;


    @Override
    public UsersDto save(UsersDto dto) {
        Users rech = repository.findByPseudo(dto.getPseudo());

       if(rech!=null)
       {
           throw new EntityAlreadyExistException("Data Already Exist");
       }else{
           Profil profilId = profilRepository.findById(dto.getProfil().getId()).orElseThrow(()->new EntityNotFoundException("Profil Data Not Found"));
           Users users = Users.builder()
                   .nom(dto.getNom())
                   .prenom(dto.getPrenom())
                   .pseudo(dto.getPseudo())
                   .email(dto.getEmail())
                   .password(dto.getPassword())
                   .profil(profilId)
                   .build();
           return UsersDto.toDto(repository.save(users));
   }
 }

    @Override
    public UsersDto update(UsersDto dto, Long id) {

            if(dto.getProfil()==null || dto.getProfil().getId()==null)
            {
                throw new IllegalArgumentException("Direction information is missing or invalid");
            }else {
                Profil profilId = profilRepository.findById(dto.getProfil().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
          return repository.findById(id).map(
                  p->{
                     p.setNom(dto.getNom());
                     p.setPrenom(dto.getPrenom());
                     p.setPseudo(dto.getPseudo());
                     p.setEmail(dto.getEmail());
                     p.setPassword(dto.getPassword());
                     p.setProfil(profilId);
                     return UsersDto.toDto(repository.save(p));
                  }
          ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));


        }
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Data Not Found");
        }

    }

    @Override
    public UsersDto findById(Long id) {
        return repository.findById(id).map(UsersDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<UsersDto> findAll() {
        return repository.findAll().stream().map(UsersDto::toDto).collect(Collectors.toList());
    }
}
