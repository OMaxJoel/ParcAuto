package com.ccc.parcauto.detail_piece.controller;

import com.ccc.parcauto.detail_piece.model.DetailPieces;
import com.ccc.parcauto.detail_piece.model.dto.DetailPiecesDto;
import com.ccc.parcauto.detail_piece.service.DetailPiecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailpieces")
@RequiredArgsConstructor
public class DetailPiecesController {
    @Autowired
    DetailPiecesService service;

    @PostMapping("/")
    public ResponseEntity<DetailPiecesDto> save(@RequestBody DetailPiecesDto detailPiecesDto)
    {
        return ResponseEntity.ok(service.save(detailPiecesDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailPiecesDto> update(@PathVariable Long id,@RequestBody DetailPiecesDto detailPiecesDto)
    {
        return ResponseEntity.ok(service.update(detailPiecesDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailPiecesDto> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<DetailPiecesDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailPiecesDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.findById(id));
    }

}
