package com.ccc.parcauto.direction.service.impl;

import com.ccc.parcauto.direction.model.Directions;
import com.ccc.parcauto.direction.model.dto.DirectionsDto;
import com.ccc.parcauto.direction.repository.DirectionsRepository;
import com.ccc.parcauto.direction.service.DirectionsService;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionsServiceImpl implements DirectionsService {
    @Autowired
    DirectionsRepository repository;
    @Override
    public DirectionsDto save(DirectionsDto dto) {
        Directions rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            Directions directions = Directions.builder()
                    .lib(dto.getLib())
                    .build();
            return DirectionsDto.toDto(repository.save(directions));
        }

    }

    @Override
    public DirectionsDto update(DirectionsDto dto, Long id) {
        return repository.findById(id).map(
                p->{
                    p.setLib(dto.getLib());
                    return DirectionsDto.toDto(repository.save(p));
                }
        ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public void delete(Long id) {
Optional<Directions> rech = repository.findById(id);
if(rech.isEmpty())
{
   throw new EntityNotFoundException("Data Not Found");
}else {
    repository.deleteById(id);
}
    }

    @Override
    public DirectionsDto findById(Long id) {
        return repository.findById(id).map(DirectionsDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<DirectionsDto> findAll() {
        return repository.findAll().stream().map(DirectionsDto::toDto).collect(Collectors.toList());
    }
}
