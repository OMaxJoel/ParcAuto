package com.ccc.parcauto.type_besoin.controller;

import com.ccc.parcauto.type_besoin.model.dto.TypeBesoinsDto;
import com.ccc.parcauto.type_besoin.service.TypeBesoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typebesoins")
@RequiredArgsConstructor
public class TypeBesoinsController {
    @Autowired
    TypeBesoinsService service;

    @PostMapping("/")
    public ResponseEntity<TypeBesoinsDto> save(@RequestBody TypeBesoinsDto typeBesoinsDto)
    {
        return ResponseEntity.ok(service.save(typeBesoinsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeBesoinsDto> update(@PathVariable Long id,@RequestBody TypeBesoinsDto typeBesoinsDto)
    {
        return ResponseEntity.ok(service.update(typeBesoinsDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeBesoinsDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeBesoinsDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeBesoinsDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
}
