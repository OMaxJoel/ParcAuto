package com.ccc.parcauto.type_carte.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.type_carte.model.TypeCartes;
import com.ccc.parcauto.type_carte.model.dto.TypesCartesDto;
import com.ccc.parcauto.type_carte.repository.TypeCartesRepository;
import com.ccc.parcauto.type_carte.service.TypeCartesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeCartesServiceImpl implements TypeCartesService {
    @Autowired
    TypeCartesRepository repository;
    @Override
    public TypesCartesDto save(TypesCartesDto dto) {
        TypeCartes rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            TypeCartes typeCartes = TypeCartes.builder()
                    .lib(dto.getLib())
                    .build();
            return TypesCartesDto.toDto(repository.save(typeCartes));
        }

    }

    @Override
    public TypesCartesDto update(TypesCartesDto dto, Long id) {
        TypeCartes rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return TypesCartesDto.toDto(repository.save(p));
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
    public TypesCartesDto findById(Long id) {
        return repository.findById(id).map(TypesCartesDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<TypesCartesDto> findAll() {
        return repository.findAll().stream().map(TypesCartesDto::toDto).collect(Collectors.toList());
    }
}
