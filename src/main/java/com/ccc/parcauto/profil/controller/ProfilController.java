package com.ccc.parcauto.profil.controller;

import com.ccc.parcauto.profil.model.dto.ProfilDto;
import com.ccc.parcauto.profil.service.ProfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profils")
@RequiredArgsConstructor
public class ProfilController {
    @Autowired
    ProfilService service;

    @PostMapping("/")
    public ResponseEntity<ProfilDto> save(@RequestBody ProfilDto profilDto)
    {
        return ResponseEntity.ok(service.save(profilDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfilDto> update(@PathVariable Long id,@RequestBody ProfilDto profilDto)
    {
        return ResponseEntity.ok(service.update(profilDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfilDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfilDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfilDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
}
