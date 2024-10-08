package com.ccc.parcauto.type_fournisseur.controller;

import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
import com.ccc.parcauto.type_fournisseur.model.dto.TypeFournisseurDto;
import com.ccc.parcauto.type_fournisseur.service.TypeFournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typefournisseurs")
@RequiredArgsConstructor
public class TypeFournisseurController {
    @Autowired
    TypeFournisseurService service;

    @PostMapping("/")
    public ResponseEntity<TypeFournisseurDto> save(@RequestBody TypeFournisseurDto typeFournisseurDto)
    {
        return ResponseEntity.ok(service.save(typeFournisseurDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeFournisseurDto> update(@PathVariable Long id,@RequestBody TypeFournisseurDto typeFournisseurDto)
    {
        return ResponseEntity.ok(service.update(typeFournisseurDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeFournisseurDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeFournisseurDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeFournisseurDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

}
