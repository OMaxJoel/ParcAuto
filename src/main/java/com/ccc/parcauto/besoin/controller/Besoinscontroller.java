package com.ccc.parcauto.besoin.controller;

import com.ccc.parcauto.besoin.model.dto.BesoinsDto;
import com.ccc.parcauto.besoin.service.BesoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/besoins")
@RequiredArgsConstructor
public class Besoinscontroller {
    @Autowired
    BesoinService service;

    @PostMapping("/")
    public ResponseEntity<BesoinsDto> save(@RequestBody BesoinsDto besoinsDto)
    {
        return ResponseEntity.ok(service.save(besoinsDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BesoinsDto> update(@PathVariable Long id , @RequestBody BesoinsDto besoinsDto)
    {
        return ResponseEntity.ok(service.update(besoinsDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BesoinsDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/")
    public ResponseEntity<List<BesoinsDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BesoinsDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/valider-chef-service/{id}")
    public ResponseEntity<BesoinsDto> validerChefService(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.validerChefService(id));
    }

    @PutMapping("/valider-directeur/{id}")
    public ResponseEntity<BesoinsDto> validerDirecteur(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.validerDirecteur(id));
    }
    @PutMapping("/valider-moyens-generaux/{id}")
    public ResponseEntity<BesoinsDto> validerMoyensGeneraux(@PathVariable long id)
    {
        return ResponseEntity.ok(service.validerMoyensGeneraux(id));
    }

}
