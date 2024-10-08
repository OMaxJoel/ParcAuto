package com.ccc.parcauto.chauffeur.service.impl;

import com.ccc.parcauto.chauffeur.model.Chauffeurs;
import com.ccc.parcauto.chauffeur.model.dto.ChauffeursDto;
import com.ccc.parcauto.chauffeur.repository.ChauffeursRepository;
import com.ccc.parcauto.chauffeur.service.ChauffeursService;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ChauffeursServiceImpl implements ChauffeursService {
    @Autowired
    ChauffeursRepository repository;

    @Override
    public ChauffeursDto save(ChauffeursDto dto) {
        Chauffeurs rech = repository.findByMatricule(dto.getMatricule());
        if(rech!=null)
        {
         throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            Chauffeurs chauffeurs = Chauffeurs.builder()
                    .matricule(dto.getMatricule())
                    .nom(dto.getNom())
                    .prenom(dto.getPrenom())
                    .contact(dto.getContact())
                    .numPermis(dto.getNumPermis())
                    .dateExpiration(dto.getDateExpiration())
                    .categoriePermis(dto.getCategoriePermis())
                    .statut(dto.isStatut())
                    .build();
            return ChauffeursDto.toDto(repository.save(chauffeurs));
        }

    }

    @Override
    public ChauffeursDto update(ChauffeursDto dto, Long id) {

        return repository.findById(id).map(
                p->{
                    p.setMatricule(dto.getMatricule());
                    p.setNom(dto.getNom());
                    p.setPrenom(dto.getPrenom());
                    p.setContact(dto.getContact());
                    p.setNumPermis(dto.getNumPermis());
                    p.setDateExpiration(dto.getDateExpiration());
                    p.setCategoriePermis(dto.getCategoriePermis());
                    p.setStatut(dto.isStatut());
                    return ChauffeursDto.toDto(repository.save(p));
                }
        ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public void delete(Long id) {
   if(repository.existsById(id))
   {
    repository.deleteById(id);
   }else{
       throw new EntityNotFoundException("Data Not Found");
   }
    }

    @Override
    public ChauffeursDto findById(Long id) {
        return repository.findById(id).map(ChauffeursDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<ChauffeursDto> findAll() {
        return repository.findAll().stream().map(ChauffeursDto::toDto).collect(Collectors.toList());
    }
}
