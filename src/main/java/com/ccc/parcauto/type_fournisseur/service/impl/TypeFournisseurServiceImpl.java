package com.ccc.parcauto.type_fournisseur.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
import com.ccc.parcauto.type_fournisseur.model.dto.TypeFournisseurDto;
import com.ccc.parcauto.type_fournisseur.repository.TypeFournisseurRepository;
import com.ccc.parcauto.type_fournisseur.service.TypeFournisseurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeFournisseurServiceImpl implements TypeFournisseurService {
    @Autowired
    TypeFournisseurRepository repository;

    @Override
    public TypeFournisseurDto save(TypeFournisseurDto dto) {
        TypeFournisseur rech = repository.findByLib(dto.getLib());

        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            TypeFournisseur typeFournisseur = TypeFournisseur.builder()
                    .lib(dto.getLib())
                    .build();

            return TypeFournisseurDto.toDto(repository.save(typeFournisseur));
        }


    }

    @Override
    public TypeFournisseurDto update(TypeFournisseurDto dto, Long id) {
        TypeFournisseur rech = repository.findByLib(dto.getLib());

        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {

            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());

                        return TypeFournisseurDto.toDto(repository.save(p));
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
    public TypeFournisseurDto findById(Long id) {
        return repository.findById(id).map(TypeFournisseurDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<TypeFournisseurDto> findAll() {
        return repository.findAll().stream().map(TypeFournisseurDto::toDto).collect(Collectors.toList());
    }
}
