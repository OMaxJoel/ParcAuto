package com.ccc.parcauto.categorie_piece.service.impl;

import com.ccc.parcauto.categorie_piece.model.CategoriePieces;
import com.ccc.parcauto.categorie_piece.model.dto.CategoriePiecesDto;
import com.ccc.parcauto.categorie_piece.repository.CategoriePiecesRepository;
import com.ccc.parcauto.categorie_piece.service.CategoriePiecesService;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriePiecesServiceImpl implements CategoriePiecesService {
    @Autowired
    CategoriePiecesRepository repository;

    @Override
    public CategoriePiecesDto save(CategoriePiecesDto dto) {
        CategoriePieces rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            CategoriePieces categoriePieces = CategoriePieces.builder()
                    .lib(dto.getLib())
                    .build();
            return CategoriePiecesDto.toDto(repository.save(categoriePieces));
        }

    }

    @Override
    public CategoriePiecesDto update(CategoriePiecesDto dto, Long id) {
        CategoriePieces rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        return CategoriePiecesDto.toDto(repository.save(p));
                    }
            ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        }

    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id))
        {
            repository.deleteById(id);

        }else{
            throw new EntityNotFoundException("Data Not Found");
        }

    }

    @Override
    public CategoriePiecesDto findById(Long id) {
        return repository.findById(id).map(CategoriePiecesDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<CategoriePiecesDto> findAll() {
        return repository.findAll().stream().map(CategoriePiecesDto::toDto).collect(Collectors.toList());
    }
}
