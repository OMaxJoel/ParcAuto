package com.ccc.parcauto.besoin.service;

import com.ccc.parcauto.abstracts.AbstractService;
import com.ccc.parcauto.besoin.model.dto.BesoinsDto;

public interface BesoinService extends AbstractService<BesoinsDto> {
    BesoinsDto validerChefService(Long id);
    BesoinsDto validerDirecteur(Long id);
    BesoinsDto validerMoyensGeneraux(Long id);
}
