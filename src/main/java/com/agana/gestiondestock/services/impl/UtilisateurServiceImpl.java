package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.UtilisateurDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Utilisateur;
import com.agana.gestiondestock.repository.UtilisateurRepository;
import com.agana.gestiondestock.services.UtilisateurService;
import com.agana.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){ this.utilisateurRepository = utilisateurRepository;}
    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);

        if (!errors.isEmpty()){
            log.error("L'utilisateur is not valid {}", utilisateurDto);
            throw  new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID ,errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(utilisateurDto)
                )
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null){
            log.error("Utilisateur ID is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(
                UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()-> new EntityNotFoundException(
                        "Utilisateur not found with ID "+id ,ErrorCodes.USER_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Utilisateur ID is null");
            return;
        }
        this.utilisateurRepository.deleteById(id);
    }
}
