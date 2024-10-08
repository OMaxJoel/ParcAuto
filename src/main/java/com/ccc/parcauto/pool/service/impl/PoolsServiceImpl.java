package com.ccc.parcauto.pool.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.pool.model.Pools;
import com.ccc.parcauto.pool.model.dto.PoolsDto;
import com.ccc.parcauto.pool.repository.PoolsRepository;
import com.ccc.parcauto.pool.service.PoolsService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.tomcat.jni.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoolsServiceImpl implements PoolsService {
    @Autowired
    PoolsRepository repository;
    @Override
    public PoolsDto save(PoolsDto dto) {
        Pools rech = repository.findByLib(dto.getLib());
        if(rech!=null)
        {
        throw new EntityAlreadyExistException("Data Already Exist");
        }else {
            Pools pools = Pools.builder()
                    .lib(dto.getLib())
                    .build();
            return PoolsDto.toDto(repository.save(pools));
        }
 }

    @Override
    public PoolsDto update(PoolsDto dto, Long id) {
        Pools rech = repository.findByLib(dto.getLib());
        if (rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else {
         return repository.findById(id).map(
                 p->{
                     p.setLib(dto.getLib());
                     return PoolsDto.toDto(repository.save(p));
                 }
         ).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
        }

    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Data Not Found");
        }

    }

    @Override
    public PoolsDto findById(Long id) {
        return repository.findById(id).map(PoolsDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not found"));
    }

    @Override
    public List<PoolsDto> findAll() {
        return repository.findAll().stream().map(PoolsDto::toDto).collect(Collectors.toList());
    }
}
