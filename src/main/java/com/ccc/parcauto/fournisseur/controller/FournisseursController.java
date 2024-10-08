package com.ccc.parcauto.fournisseur.controller;

import com.ccc.parcauto.fournisseur.model.dto.FournisseursDto;
import com.ccc.parcauto.fournisseur.service.FournisseursService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
@RequiredArgsConstructor
public class FournisseursController {
    @Autowired
    FournisseursService service;

    @PostMapping("/")
    public ResponseEntity<FournisseursDto> save(@RequestBody FournisseursDto fournisseursDto)
    {
        return ResponseEntity.ok(service.save(fournisseursDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FournisseursDto> update(@PathVariable Long id,@RequestBody FournisseursDto fournisseursDto)
    {
        return ResponseEntity.ok(service.update(fournisseursDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FournisseursDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<FournisseursDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FournisseursDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
}
