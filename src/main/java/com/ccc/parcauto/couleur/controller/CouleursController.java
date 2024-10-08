package com.ccc.parcauto.couleur.controller;

import com.ccc.parcauto.couleur.model.dto.CouleursDto;
import com.ccc.parcauto.couleur.service.CouleursServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/couleurs")
@RequiredArgsConstructor
public class CouleursController {
    @Autowired
    CouleursServices services;

    @PostMapping("/")
   public ResponseEntity<CouleursDto> save(@RequestBody CouleursDto couleursDto)
    {
        return ResponseEntity.ok(services.save(couleursDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouleursDto> update(@PathVariable Long id ,@RequestBody CouleursDto couleursDto)
    {
        return ResponseEntity.ok(services.update(couleursDto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CouleursDto>> findAll()
    {
        return ResponseEntity.ok(services.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouleursDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(services.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CouleursDto> delete(@PathVariable Long id)
    {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
