package com.ccc.parcauto.direction.controller;

import com.ccc.parcauto.direction.model.dto.DirectionsDto;
import com.ccc.parcauto.direction.service.DirectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directions")
@RequiredArgsConstructor
public class DirectionsController {
    @Autowired
    DirectionsService service;
    @PostMapping("/")
    public ResponseEntity<DirectionsDto> save(@RequestBody DirectionsDto dto)
    {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectionsDto> update(@PathVariable Long id,@RequestBody DirectionsDto dto)
    {
        return ResponseEntity.ok(service.update(dto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<DirectionsDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DirectionsDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DirectionsDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
