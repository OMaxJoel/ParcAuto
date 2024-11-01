package com.ccc.parcauto.detail_besoin.service.impl;

import com.ccc.parcauto.besoin.model.Besoins;
import com.ccc.parcauto.besoin.repository.BesoinRepository;
import com.ccc.parcauto.detail_besoin.model.DetailBesoins;
import com.ccc.parcauto.detail_besoin.model.dto.DetailBesoinsDto;
import com.ccc.parcauto.detail_besoin.repository.DetailBesoinrepository;
import com.ccc.parcauto.detail_besoin.service.DetailBesoinService;
import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailBesoinServiceImpl implements DetailBesoinService {
    @Autowired
    DetailBesoinrepository detailBesoinrepository;
    @Autowired
    BesoinRepository besoinRepository;

    @Override
    public DetailBesoinsDto save(DetailBesoinsDto dto) {
        DetailBesoins rech = detailBesoinrepository.findByDescription(dto.getDescription());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{

            BigInteger total = dto.getPrix_u().multiply(dto.getQte());
            Besoins besoinsId = besoinRepository.findById(dto.getBesoins().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            DetailBesoins detailBesoins = DetailBesoins.builder()
                    .description(dto.getDescription())
                    .qte(dto.getQte())
                    .prix_u(dto.getPrix_u())
                    .totalBesoins(total)
                    .besoins(besoinsId)
                    .build();
            return DetailBesoinsDto.toDto(detailBesoinrepository.save(detailBesoins));
        }
    }

    @Override
    public DetailBesoinsDto update(DetailBesoinsDto dto, Long id) {
     if(dto.getBesoins()==null || dto.getBesoins().getId()==null)
     {
         throw new IllegalArgumentException("Besoin information is missing or invalid");
     }
 BigInteger total = dto.getQte().multiply(dto.getPrix_u());
 //Besoins besoinsId = besoinRepository.findById(dto.getBesoins().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
 return detailBesoinrepository.findById(id).map(
         p->{
             p.setDescription(dto.getDescription());
             p.setQte(dto.getQte());
             p.setPrix_u(dto.getPrix_u());
             p.setTotalBesoins(total);
return DetailBesoinsDto.toDto(detailBesoinrepository.save(p));
         }
 ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public void delete(Long id) {
        if(detailBesoinrepository.existsById(id))
        {
            detailBesoinrepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Data Not Found");
        }
    }

    @Override
    public DetailBesoinsDto findById(Long id) {
        return detailBesoinrepository.findById(id).map(DetailBesoinsDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<DetailBesoinsDto> findAll() {
        return detailBesoinrepository.findAll().stream().map(DetailBesoinsDto::toDto).collect(Collectors.toList());
    }
}
