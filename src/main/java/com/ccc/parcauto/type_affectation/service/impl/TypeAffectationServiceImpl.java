package com.ccc.parcauto.type_affectation.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.type_affectation.model.TypeAffectations;
import com.ccc.parcauto.type_affectation.model.dto.TypeAffectationDto;
import com.ccc.parcauto.type_affectation.repository.TypeAffectationRepository;
import com.ccc.parcauto.type_affectation.service.TypeAffectationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeAffectationServiceImpl implements TypeAffectationService {
   @Autowired
    TypeAffectationRepository repository;

    @Override
    public TypeAffectationDto save(TypeAffectationDto dto) {
        TypeAffectations rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data already Exist");
        }else {
            TypeAffectations typeAffectations = TypeAffectations.builder()
                    .lib(dto.getLib())
                    .build();
            return TypeAffectationDto.toDto(repository.save(typeAffectations));
        }

    }

    @Override
    public TypeAffectationDto update(TypeAffectationDto dto, Long id) {
        TypeAffectations rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return TypeAffectationDto.toDto(repository.save(p));
                    }
            ).orElseThrow(()-> new EntityNotFoundException("Data Not find"));
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
    public TypeAffectationDto findById(Long id) {
        return repository.findById(id).map(TypeAffectationDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<TypeAffectationDto> findAll() {
        return repository.findAll().stream().map(TypeAffectationDto::toDto).collect(Collectors.toList());
    }
}
