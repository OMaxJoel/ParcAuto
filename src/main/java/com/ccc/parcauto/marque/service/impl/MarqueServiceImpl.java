package com.ccc.parcauto.marque.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.marque.model.Marques;
import com.ccc.parcauto.marque.model.dto.MarquesDto;
import com.ccc.parcauto.marque.repository.MarquesRepository;
import com.ccc.parcauto.marque.service.MarquesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarqueServiceImpl implements MarquesService {
    @Autowired
    MarquesRepository repository;

    @Override
    public MarquesDto save(MarquesDto dto) {
        Marques rech = repository.findByLib(dto.getLib());

        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already exist");
        }else{
        Marques marques = Marques.builder()
        .lib(dto.getLib())
        .build();
      return MarquesDto.toDto(repository.save(marques));
        }

    }

    @Override
    public MarquesDto update(MarquesDto dto, Long id) {
    Marques rech = repository.findByLib(dto.getLib());
    if(rech!=null)
    {
      throw new EntityAlreadyExistException("Data Already Exist");
    }else{
        return repository.findById(id).map(
                p->{
                    p.setLib(dto.getLib());
                    return MarquesDto.toDto(repository.save(p));
                }
        ).orElseThrow(()->new EntityNotFoundException("Data not found"));
    }

    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id))
        {
         repository.deleteById(id);
        }else{
         throw new EntityNotFoundException("Data Not found");
        }

    }

    @Override
    public MarquesDto findById(Long id) {
        return repository.findById(id).map(MarquesDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<MarquesDto> findAll() {
        return repository.findAll().stream().map(MarquesDto::toDto).collect(Collectors.toList());
    }
}
