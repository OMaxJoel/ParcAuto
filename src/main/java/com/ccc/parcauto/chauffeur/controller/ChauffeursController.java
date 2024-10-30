package com.ccc.parcauto.chauffeur.controller;

import com.ccc.parcauto.chauffeur.model.dto.ChauffeursDto;
import com.ccc.parcauto.chauffeur.service.ChauffeursService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chauffeurs")
@RequiredArgsConstructor
public class ChauffeursController {
    @Autowired
    ChauffeursService service;

    @PostMapping("/")
    public ResponseEntity<ChauffeursDto> save(@RequestBody ChauffeursDto chauffeursDto)
    {
        return ResponseEntity.ok(service.save(chauffeursDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChauffeursDto> update(@PathVariable Long id,@RequestBody ChauffeursDto chauffeursDto)
    {
        return ResponseEntity.ok(service.update(chauffeursDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChauffeursDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ChauffeursDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChauffeursDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
}
