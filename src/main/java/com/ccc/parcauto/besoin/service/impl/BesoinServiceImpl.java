package com.ccc.parcauto.besoin.service.impl;

import com.ccc.parcauto.Enum.StatutValidation;
import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.besoin.model.dto.BesoinsDto;
import com.ccc.parcauto.besoin.repository.BesoinRepository;
import com.ccc.parcauto.besoin.service.BesoinService;
import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.direction.model.dto.DirectionsDto;
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
public class BesoinServiceImpl implements BesoinService {
    @Autowired
    BesoinRepository repository;
    @Autowired
    DirectionsRepository directionsRepository;
    @Autowired
    ServicesRepository servicesRepository;



    @Override
    public BesoinsDto save(BesoinsDto dto) {
        Besoins rech = repository.findByusagePrincipale(dto.getUsagePrincipale());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
            Directions directionsId = directionsRepository.findById(dto.getDirections().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            Services servicesId = servicesRepository.findById(dto.getServices().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            Besoins besoins = Besoins.builder()
                    .dateDemande(dto.getDateDemande())
                    .usagePrincipale(dto.getUsagePrincipale())
                    .urgence(dto.getUrgence())
                    .directions(directionsId)
                    .services(servicesId)
                    .statutValidation(StatutValidation.EN_ATTENTE)
                    .build();
            return BesoinsDto.toDto(repository.save(besoins));
        }

    }

    @Override
    public BesoinsDto update(BesoinsDto dto, Long id) {
        return repository.findById(id).map(
                p->{
                    p.setDateDemande(dto.getDateDemande());
                    p.setUsagePrincipale(dto.getUsagePrincipale());
                    p.setUrgence(dto.getUrgence());
                    return BesoinsDto.toDto(repository.save(p));
                }
        ).orElseThrow(()-> new EntityNotFoundException("Data Not found"));
    }

    @Override
    public void delete(Long id) {
Optional<Besoins> rech = repository.findById(id);
if(rech.isEmpty())
{
    throw new EntityNotFoundException("Data Not Found");
}else {
    repository.deleteById(id);
}
    }

    @Override
    public BesoinsDto findById(Long id) {
        return repository.findById(id).map(BesoinsDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not found"));
    }

    @Override
    public List<BesoinsDto> findAll() {
        return repository.findAll().stream().map(BesoinsDto::toDto).collect(Collectors.toList());
    }

    @Override
    public BesoinsDto validerChefService(Long id) {
        Besoins besoins = repository.findById(id).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        if(StatutValidation.EN_ATTENTE.equals(besoins.getStatutValidation()))
        {
            besoins.setStatutValidation(StatutValidation.VALIDEE_CHEF_SERVICE);
        }
        return BesoinsDto.toDto(repository.save(besoins));
    }

    @Override
    public BesoinsDto validerDirecteur(Long id) {
        Besoins besoins = repository.findById(id).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        if (StatutValidation.VALIDEE_CHEF_SERVICE.equals(besoins.getStatutValidation()))
        {
            besoins.setStatutValidation(StatutValidation.VALIDEE_DIRECTEUR);
        }
        return BesoinsDto.toDto(repository.save(besoins));
    }

    @Override
    public BesoinsDto validerMoyensGeneraux(Long id) {
        Besoins besoins = repository.findById(id).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        if (StatutValidation.VALIDEE_DIRECTEUR.equals(besoins.getStatutValidation()))
        {
            besoins.setStatutValidation(StatutValidation.VALIDEE_MOYENS_GENERAUX);
        }
        return BesoinsDto.toDto(repository.save(besoins));
    }
}
