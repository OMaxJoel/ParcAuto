package com.ccc.parcauto.detail_piece.service.impl;

import com.ccc.parcauto.categorie_piece.model.CategoriePieces;
import com.ccc.parcauto.categorie_piece.repository.CategoriePiecesRepository;
import com.ccc.parcauto.detail_piece.model.DetailPieces;
import com.ccc.parcauto.detail_piece.model.dto.DetailPiecesDto;
import com.ccc.parcauto.detail_piece.repository.DetailPiecesRepository;
import com.ccc.parcauto.detail_piece.service.DetailPiecesService;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DetailPiecesServiceImpl implements DetailPiecesService {
    @Autowired
    DetailPiecesRepository repository;
    @Autowired
    CategoriePiecesRepository categoriePiecesRepository;
    @Override
    public DetailPiecesDto save(DetailPiecesDto dto) {
        DetailPieces rech = repository.findByLib(dto.getLib());
        if (rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            CategoriePieces categoriePiecesId = categoriePiecesRepository.findById(dto.getCategoriePieces().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            DetailPieces detailPieces = DetailPieces.builder()
                    .lib(dto.getLib())
                    .categoriePieces(categoriePiecesId)
                    .build();
            return DetailPiecesDto.toDto(repository.save(detailPieces));
        }

    }

    @Override
    public DetailPiecesDto update(DetailPiecesDto dto, Long id) {
        if(dto.getCategoriePieces()==null || dto.getCategoriePieces().getId()==null)
        {
           throw new IllegalArgumentException("categorie piece information is missing or invalid");
        }else{
            CategoriePieces categoriePiecesId= categoriePiecesRepository.findById(dto.getCategoriePieces().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            return repository.findById(id).map(
                    p->{
                        p.setLib(dto.getLib());
                        p.setCategoriePieces(categoriePiecesId);
                        return DetailPiecesDto.toDto(repository.save(p));
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
      throw new EntityNotFoundException("data Not Found");
  }
    }

    @Override
    public DetailPiecesDto findById(Long id) {
        return repository.findById(id).map(DetailPiecesDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<DetailPiecesDto> findAll() {
        return repository.findAll().stream().map(DetailPiecesDto::toDto).collect(Collectors.toList());
    }
}
