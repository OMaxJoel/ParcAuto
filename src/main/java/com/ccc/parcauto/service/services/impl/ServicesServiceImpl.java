package com.ccc.parcauto.service.services.impl;

import com.ccc.parcauto.abstracts.AbstractEntity;
import com.ccc.parcauto.abstracts.AbstractService;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.direction.repository.DirectionsRepository;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.service.model.Services;
import com.ccc.parcauto.service.model.dto.ServicesDto;
import com.ccc.parcauto.service.repository.ServicesRepository;
import com.ccc.parcauto.service.services.ServicesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    ServicesRepository repository;
    @Autowired
    DirectionsRepository directionsRepository;
    @Override
    public ServicesDto save(ServicesDto dto) {
        Services rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            Directions directionsId = directionsRepository.findById(dto.getDirections().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));

            Services services = Services.builder()
                    .lib(dto.getLib())
                    .directions(directionsId)
                    .build();
          return ServicesDto.toDto(repository.save(services));
        }
   }

    @Override
    public ServicesDto update(ServicesDto dto, Long id) {

        // Vérification que l'objet DirectionsDto n'est pas nul
        if (dto.getDirections() == null || dto.getDirections().getId() == null) {
            throw new IllegalArgumentException("Direction information is missing or invalid");
        }
        Directions directionsId = directionsRepository.findById(dto.getDirections().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        return repository.findById(id).map(
                p->{
                    p.setLib(dto.getLib());
                    p.setDirections(directionsId);
                    return ServicesDto.toDto(repository.save(p));
                }
        ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public void delete(Long id) {

if(!repository.existsById(id))
{
    throw new EntityNotFoundException("Data Not Found");
}else {
    repository.deleteById(id);
}
  }

    @Override
    public ServicesDto findById(Long id) {
        return repository.findById(id).map(ServicesDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<ServicesDto> findAll() {
        return repository.findAll().stream().map(ServicesDto::toDto).collect(Collectors.toList());
    }
}
