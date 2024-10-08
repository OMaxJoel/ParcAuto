package com.ccc.parcauto.marque.controller;

import com.ccc.parcauto.marque.model.Marques;
import com.ccc.parcauto.marque.model.dto.MarquesDto;
import com.ccc.parcauto.marque.service.MarquesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marques")
@RequiredArgsConstructor
public class MarqueController {
    @Autowired
    MarquesService service;

    @PostMapping("/")
    public ResponseEntity<MarquesDto> save(@RequestBody MarquesDto marquesDto)
    {
        return ResponseEntity.ok(service.save(marquesDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MarquesDto> update(@PathVariable Long id,@RequestBody MarquesDto marquesDto)
    {
        return ResponseEntity.ok(service.update(marquesDto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<MarquesDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarquesDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MarquesDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
