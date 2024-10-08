package com.ccc.parcauto.user.controller;

import com.ccc.parcauto.user.model.dto.UsersDto;
import com.ccc.parcauto.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    @Autowired
    UsersService service;

    @PostMapping("/")
    public ResponseEntity<UsersDto> save(@RequestBody UsersDto usersDto)
    {
        return ResponseEntity.ok(service.save(usersDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> update(@PathVariable Long id,@RequestBody UsersDto usersDto)
    {
        return ResponseEntity.ok(service.update(usersDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsersDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> findById(@PathVariable Long id)
    {
       return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/")
    public ResponseEntity<List<UsersDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
}
