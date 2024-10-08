package com.ccc.parcauto.abstracts;

import java.util.List;

public interface AbstractService <T>{
    T save(T dto);
    T update(T dto, Long id);
    void delete (Long id);
    T findById(Long id);
    List<T> findAll();
}