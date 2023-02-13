package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.FournisseurDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Fournisseur;
import com.agana.gestiondestock.repository.FournisseurRepository;
import com.agana.gestiondestock.services.FournisseurService;
import com.agana.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {this.fournisseurRepository = fournisseurRepository;}
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()){
            log.error("Fournisseur is not valid {}",fournisseurDto);
            throw new InvalidEntityException("Fournisseur  n'est pas valide", ErrorCodes.PROVIDER_NOT_VALID,errors);
        }
        return FournisseurDto.fromEntity(
                fournisseurRepository.save(
                        FournisseurDto.toEntity(fournisseurDto)
                )
        );
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null){
            log.error("Fournisseur ID is null");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(
                FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()-> new EntityNotFoundException(
                        "not found with ID  "+id,ErrorCodes.COMPANIES_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Fournisseur  ID is null");
            return;
        }
        this.fournisseurRepository.deleteById(id);
    }
}
