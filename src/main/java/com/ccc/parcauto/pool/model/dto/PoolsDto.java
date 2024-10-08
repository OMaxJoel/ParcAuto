package com.ccc.parcauto.pool.model.dto;

import com.ccc.parcauto.pool.model.Pools;
import lombok.*;

import javax.swing.text.html.parser.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoolsDto {
    private Long id;
    private String lib;

    public static PoolsDto toDto(Pools pools)
    {
        return PoolsDto.builder()
                .id(pools.getId())
                .lib(pools.getLib())
                .build();
    }

    public static Pools toEntity(PoolsDto poolsDto)
    {
        return Pools.builder()
                .id(poolsDto.getId())
                .lib(poolsDto.getLib())
                .build();
    }
}
