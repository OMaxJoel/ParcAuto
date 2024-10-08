package com.ccc.parcauto.profil.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.profil.model.Profil;
import com.ccc.parcauto.profil.model.dto.ProfilDto;
import com.ccc.parcauto.profil.repository.ProfilRepository;
import com.ccc.parcauto.profil.service.ProfilService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    ProfilRepository repository;
    @Override
    public ProfilDto save(ProfilDto dto) {
        Profil rech = repository.findByLib(dto.getLib());

        if(rech!=null)
        {
          throw new EntityAlreadyExistException("Data Already Exist");
        }else {
          Profil profil = Profil.builder()
                  .lib(dto.getLib())
                  .build();

            return ProfilDto.toDto(repository.save(profil));
        }

    }

    @Override
    public ProfilDto update(ProfilDto dto, Long id) {
        Profil rech = repository.findByLib(dto.getLib());

        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return ProfilDto.toDto(repository.save(p));
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
    public ProfilDto findById(Long id) {
        return repository.findById(id).map(ProfilDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<ProfilDto> findAll() {
        return repository.findAll().stream().map(ProfilDto::toDto).collect(Collectors.toList());
    }
}
