package com.ccc.parcauto.detail_besoin.controller;

import com.ccc.parcauto.detail_besoin.model.dto.DetailBesoinsDto;
import com.ccc.parcauto.detail_besoin.service.DetailBesoinService;
import com.ccc.parcauto.direction.model.dto.DirectionsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail-besoins")
@RequiredArgsConstructor
public class DetailBesoinController {
    @Autowired
    DetailBesoinService service;

    @PostMapping("/")
    public ResponseEntity<DetailBesoinsDto> save(@RequestBody DetailBesoinsDto detailBesoinsDto)
    {
        return ResponseEntity.ok(service.save(detailBesoinsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailBesoinsDto> update(@PathVariable Long id, @RequestBody DetailBesoinsDto detailBesoinsDto)
    {
        return ResponseEntity.ok(service.update(detailBesoinsDto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<DetailBesoinsDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetailBesoinsDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DetailBesoinsDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
