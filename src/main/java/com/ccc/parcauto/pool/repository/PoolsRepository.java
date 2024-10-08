package com.ccc.parcauto.pool.repository;

import com.ccc.parcauto.pool.model.Pools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolsRepository extends JpaRepository<Pools,Long> {
    Pools findByLib(String lib);
}
