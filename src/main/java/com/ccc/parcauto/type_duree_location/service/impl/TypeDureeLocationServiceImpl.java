package com.ccc.parcauto.type_duree_location.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.type_duree_location.model.TypeDureeLocation;
import com.ccc.parcauto.type_duree_location.model.dto.TypeDureeLocationDto;
import com.ccc.parcauto.type_duree_location.repository.TypeDureeLocationRepository;
import com.ccc.parcauto.type_duree_location.service.TypeDureeLocationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeDureeLocationServiceImpl implements TypeDureeLocationService {
    @Autowired
    TypeDureeLocationRepository repository;

    @Override
    public TypeDureeLocationDto save(TypeDureeLocationDto dto) {
        TypeDureeLocation rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
            TypeDureeLocation typeDureeLocation = TypeDureeLocation.builder()
                    .lib(dto.getLib())
                    .build();

            return TypeDureeLocationDto.toDto(repository.save(typeDureeLocation));
        }

    }

    @Override
    public TypeDureeLocationDto update(TypeDureeLocationDto dto, Long id) {
        TypeDureeLocation rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
          return repository.findById(id).map(
               p->{
                   p.setLib(dto.getLib());
                   return TypeDureeLocationDto.toDto(repository.save(p));
               }
          ).orElseThrow(()->new EntityNotFoundException("Data not Found"));
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
    public TypeDureeLocationDto findById(Long id) {
        return repository.findById(id).map(TypeDureeLocationDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<TypeDureeLocationDto> findAll() {
        return repository.findAll().stream().map(TypeDureeLocationDto::toDto).collect(Collectors.toList());
    }
}
