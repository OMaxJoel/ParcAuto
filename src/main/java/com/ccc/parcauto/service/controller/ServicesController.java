package com.ccc.parcauto.service.controller;

import com.ccc.parcauto.service.model.dto.ServicesDto;
import com.ccc.parcauto.service.services.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServicesController {
    @Autowired
    ServicesService service;

    @PostMapping("/")
    public ResponseEntity<ServicesDto> save(@RequestBody ServicesDto dto)
    {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesDto> update(@PathVariable Long id,@RequestBody ServicesDto dto)
    {
        return ResponseEntity.ok(service.update(dto, id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ServicesDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServicesDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
