package com.ccc.parcauto.couleur.service.impl;

import com.ccc.parcauto.couleur.model.Couleurs;
import com.ccc.parcauto.couleur.model.dto.CouleursDto;
import com.ccc.parcauto.couleur.repository.CouleursRepository;
import com.ccc.parcauto.couleur.service.CouleursServices;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouleursServiceImpl implements CouleursServices {
    @Autowired
    CouleursRepository repository;
    @Override
    public CouleursDto save(CouleursDto dto) {
        Couleurs rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            Couleurs couleurs = Couleurs.builder()
                    .lib(dto.getLib())
                    .build();
            return CouleursDto.toDto(repository.save(couleurs));
        }

    }

    @Override
    public CouleursDto update(CouleursDto dto, Long id) {

        Couleurs rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return CouleursDto.toDto(repository.save(p));
                    }
            ).orElseThrow(()->new EntityNotFoundException("Data Not found"));
        }

    }

    @Override
    public void delete(Long id) {
     if (repository.existsById(id))
     {
         repository.deleteById(id);
     }else {
         throw new EntityNotFoundException("Data Not found");
     }
    }

    @Override
    public CouleursDto findById(Long id) {
        return repository.findById(id).map(CouleursDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<CouleursDto> findAll() {
        return repository.findAll().stream().map(CouleursDto::toDto).collect(Collectors.toList());
    }
}
