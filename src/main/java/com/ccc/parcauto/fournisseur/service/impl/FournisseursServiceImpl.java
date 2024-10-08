package com.ccc.parcauto.fournisseur.service.impl;

import com.ccc.parcauto.exceptions.EntityAlreadyExistException;
import com.ccc.parcauto.fournisseur.model.Fournisseurs;
import com.ccc.parcauto.fournisseur.model.dto.FournisseursDto;
import com.ccc.parcauto.fournisseur.repository.FournisseursRepository;
import com.ccc.parcauto.fournisseur.service.FournisseursService;
import com.ccc.parcauto.type_fournisseur.model.TypeFournisseur;
import com.ccc.parcauto.type_fournisseur.repository.TypeFournisseurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseursServiceImpl implements FournisseursService {

    @Autowired
    FournisseursRepository repository;
    @Autowired
    TypeFournisseurRepository typeFournisseurRepository;

    @Override
    public FournisseursDto save(FournisseursDto dto) {
        Fournisseurs rech = repository.findByNomFournisseur(dto.getNomFournisseur());
        if(rech!=null)
        {
            throw new EntityAlreadyExistException("Data Already Exist");
        }else{
            TypeFournisseur typeFournisseurId = typeFournisseurRepository.findById(dto.getTypeFournisseur().getId()).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
            Fournisseurs fournisseurs = Fournisseurs.builder()
                    .nomFournisseur(dto.getNomFournisseur())
                    .pays(dto.getPays())
                    .situationGeo(dto.getSituationGeo())
                    .telephone(dto.getTelephone())
                    .email(dto.getEmail())
                    .nomContact(dto.getNomContact())
                    .telephoneContact(dto.getTelephoneContact())
                    .emailContact(dto.getEmailContact())
                    .statut(dto.isStatut())
                    .typeFournisseur(typeFournisseurId)
                    .build();
            return FournisseursDto.toDto(repository.save(fournisseurs));
        }

    }

    @Override
    public FournisseursDto update(FournisseursDto dto, Long id) {
        if(dto.getTypeFournisseur()==null || dto.getTypeFournisseur().getId()==null)
        {
            throw new IllegalArgumentException("Direction information is missing or invalid");
        }else {
            TypeFournisseur typeFournisseurId = typeFournisseurRepository.findById(dto.getTypeFournisseur().getId()).orElseThrow(()->new EntityNotFoundException("ID type fournisseur Not Found"));
            return repository.findById(id).map(
                    p->{
                        p.setNomFournisseur(dto.getNomFournisseur());
                        p.setPays(dto.getPays());
                        p.setSituationGeo(dto.getSituationGeo());
                        p.setTelephone(dto.getTelephone());
                        p.setEmail(dto.getEmail());
                        p.setNomContact(dto.getNomContact());
                        p.setTelephoneContact(dto.getTelephoneContact());
                        p.setEmailContact(dto.getEmailContact());
                        p.setStatut(dto.isStatut());
                        p.setTypeFournisseur(typeFournisseurId);
                        return FournisseursDto.toDto(repository.save(p));
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
    public FournisseursDto findById(Long id) {
        return repository.findById(id).map(FournisseursDto::toDto).orElseThrow(()->new EntityNotFoundException("Data Not Found"));
    }

    @Override
    public List<FournisseursDto> findAll() {
        return repository.findAll().stream().map(FournisseursDto::toDto).collect(Collectors.toList());
    }
}
