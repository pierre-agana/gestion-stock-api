package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.VentesDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.LigneVente;
import com.agana.gestiondestock.model.Ventes;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.repository.LigneVenteRepository;
import com.agana.gestiondestock.repository.VentesRepository;
import com.agana.gestiondestock.services.VentesServices;
import com.agana.gestiondestock.validator.CommandeFournisseurValidator;
import com.agana.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ventesServiceImpl implements VentesServices {
    private VentesRepository ventesRepository;
    private ArticleRepository articleRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public ventesServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository){
        this.ventesRepository = ventesRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String> errors = VentesValidator.validate(ventesDto);
        if (!errors.isEmpty()){
            log.error("La vente n'est pas valide ");
            throw  new InvalidEntityException("", ErrorCodes.SALE_NOT_VALID, errors);
        }
        List<String> articleErros = new ArrayList<>();
        //pour chaque ligne de vente recuperer l4
        // 'article
        ventesDto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (!article.isEmpty()){
                articleErros.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId()+ " n'a ete trouve");
            }
        });
        if (!articleErros.isEmpty()){
            log.error("One or more article were not found {}", errors);
            throw  new InvalidEntityException("Une ou plusieurs articles sont introuvable ",ErrorCodes.SALE_NOT_VALID, errors);
        }
        Ventes saveVentes = ventesRepository.save(VentesDto.toEntity(ventesDto));

        ventesDto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = ligneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVentes(saveVentes);
            ligneVenteRepository.save(ligneVente);
        });

        return VentesDto.fromEntity(saveVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null){
            log.error("vente ID is null");
            return null;
        }
        return ventesRepository.findById(id).map(VentesDto::fromEntity).orElseThrow(()-> new EntityNotFoundException(
                "Aucune vente n'a ete trouve", ErrorCodes.SALE_NOT_FOUND
        ));
    }

    @Override
    public VentesDto findVentesByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Vente  CODE is null");
            return null;
        }
        return ventesRepository.findVentesByCode(code).map(VentesDto::fromEntity).orElseThrow(()-> new EntityNotFoundException(
                "Aucune vente n'a ete trouver avec le code " +code, ErrorCodes.SALE_NOT_FOUND
        ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(VentesDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Vente ID is null");
            return ;
        }
        ventesRepository.deleteById(id);
    }
}
