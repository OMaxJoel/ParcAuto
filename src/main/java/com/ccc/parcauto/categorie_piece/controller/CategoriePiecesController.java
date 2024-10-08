package com.ccc.parcauto.categorie_piece.controller;

import com.ccc.parcauto.categorie_piece.model.dto.CategoriePiecesDto;
import com.ccc.parcauto.categorie_piece.service.CategoriePiecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriepieces")
@RequiredArgsConstructor
public class CategoriePiecesController {
    @Autowired
    CategoriePiecesService service;

    @PostMapping("/")
    public ResponseEntity<CategoriePiecesDto> save(@RequestBody CategoriePiecesDto categoriePiecesDto)
    {
        return ResponseEntity.ok(service.save(categoriePiecesDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriePiecesDto> update(@PathVariable Long id,@RequestBody CategoriePiecesDto categoriePiecesDto)
    {
        return ResponseEntity.ok(service.update(categoriePiecesDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriePiecesDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoriePiecesDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriePiecesDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

}
