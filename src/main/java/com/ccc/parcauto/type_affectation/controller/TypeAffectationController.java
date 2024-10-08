package com.ccc.parcauto.type_affectation.controller;

import com.ccc.parcauto.type_affectation.model.dto.TypeAffectationDto;
import com.ccc.parcauto.type_affectation.service.TypeAffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeaffectation")
@RequiredArgsConstructor
public class TypeAffectationController {
    @Autowired
    TypeAffectationService service;

    @PostMapping("/")
    public ResponseEntity<TypeAffectationDto> save(@RequestBody TypeAffectationDto typeAffectationDto)
    {
        return ResponseEntity.ok(service.save(typeAffectationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeAffectationDto> update(@PathVariable Long id,@RequestBody TypeAffectationDto typeAffectationDto)
    {
        return ResponseEntity.ok(service.update(typeAffectationDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeAffectationDto> delete(@PathVariable Long id)
    {
       service.delete(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeAffectationDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAffectationDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
}
