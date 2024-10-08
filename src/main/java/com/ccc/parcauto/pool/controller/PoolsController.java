package com.ccc.parcauto.pool.controller;

import com.ccc.parcauto.pool.model.dto.PoolsDto;
import com.ccc.parcauto.pool.service.PoolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pools")
@RequiredArgsConstructor
public class PoolsController {

    @Autowired
    PoolsService service;

    @PostMapping("/")
    public ResponseEntity<PoolsDto> save(@RequestBody PoolsDto poolsDto)
    {
        return ResponseEntity.ok(service.save(poolsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoolsDto> update(@PathVariable Long id,@RequestBody PoolsDto poolsDto)
    {
        return ResponseEntity.ok(service.update(poolsDto,id));
    }

    @GetMapping("/")
    public ResponseEntity<List<PoolsDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoolsDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PoolsDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
