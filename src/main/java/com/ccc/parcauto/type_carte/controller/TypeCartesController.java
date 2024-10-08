package com.ccc.parcauto.type_carte.controller;

import com.ccc.parcauto.type_carte.model.dto.TypesCartesDto;
import com.ccc.parcauto.type_carte.service.TypeCartesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typecartes")
@RequiredArgsConstructor
public class TypeCartesController {

    @Autowired
    TypeCartesService service;

    @PostMapping("/")
    public ResponseEntity<TypesCartesDto> save(@RequestBody TypesCartesDto typesCartesDto)
    {
        return ResponseEntity.ok(service.save(typesCartesDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypesCartesDto> update(@PathVariable Long id,@RequestBody TypesCartesDto typesCartesDto)
    {
        return ResponseEntity.ok(service.update(typesCartesDto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<TypesCartesDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypesCartesDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypesCartesDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
