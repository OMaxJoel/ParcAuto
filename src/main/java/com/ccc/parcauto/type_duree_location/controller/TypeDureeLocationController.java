package com.ccc.parcauto.type_duree_location.controller;

import com.ccc.parcauto.type_duree_location.model.TypeDureeLocation;
import com.ccc.parcauto.type_duree_location.model.dto.TypeDureeLocationDto;
import com.ccc.parcauto.type_duree_location.service.TypeDureeLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typedureelocation")
@RequiredArgsConstructor
public class TypeDureeLocationController {
    @Autowired
    TypeDureeLocationService service;

    @PostMapping("/")
    public ResponseEntity<TypeDureeLocationDto> save(@RequestBody TypeDureeLocationDto typeDureeLocationDto)
    {
        return ResponseEntity.ok(service.save(typeDureeLocationDto));
    }

   @PutMapping("/{id}")
   public ResponseEntity<TypeDureeLocationDto> update(@PathVariable Long id,@RequestBody TypeDureeLocationDto typeDureeLocationDto)
   {
       return ResponseEntity.ok(service.update(typeDureeLocationDto,id));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<TypeDureeLocationDto> delete(@PathVariable Long id)
   {
       service.delete(id);
       return ResponseEntity.noContent().build();
   }

   @GetMapping("/")
    public ResponseEntity<List<TypeDureeLocationDto>> findAll()
   {
       return ResponseEntity.ok(service.findAll());
   }

   @GetMapping("/{id}")
    public ResponseEntity<TypeDureeLocationDto> findById(@PathVariable Long id)
   {
       return ResponseEntity.ok(service.findById(id));
   }




}
