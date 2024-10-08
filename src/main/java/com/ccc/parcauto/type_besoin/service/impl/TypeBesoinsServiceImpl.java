package com.ccc.parcauto.type_besoin.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.type_besoin.model.TypeBesoins;
import com.ccc.parcauto.type_besoin.model.dto.TypeBesoinsDto;
import com.ccc.parcauto.type_besoin.repository.TypeBesoinsRepository;
import com.ccc.parcauto.type_besoin.service.TypeBesoinsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeBesoinsServiceImpl implements TypeBesoinsService {
    @Autowired
    TypeBesoinsRepository repository;
    @Override
    public TypeBesoinsDto save(TypeBesoinsDto dto) {
        TypeBesoins rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            TypeBesoins typeBesoins = TypeBesoins.builder()
                    .lib(dto.getLib())
                    .build();
            return TypeBesoinsDto.toDto(repository.save(typeBesoins));
        }

    }

    @Override
    public TypeBesoinsDto update(TypeBesoinsDto dto, Long id) {
        TypeBesoins rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {

            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return TypeBesoinsDto.toDto(repository.save(p));
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
    public TypeBesoinsDto findById(Long id) {
        return repository.findById(id).map(TypeBesoinsDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<TypeBesoinsDto> findAll() {
        return repository.findAll().stream().map(TypeBesoinsDto::toDto).collect(Collectors.toList());
    }
}
