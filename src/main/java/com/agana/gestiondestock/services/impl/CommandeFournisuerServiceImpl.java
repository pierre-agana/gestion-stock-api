package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.CommandeFournisseurDto;
import com.agana.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.CommandeFournisseur;
import com.agana.gestiondestock.model.Fournisseur;
import com.agana.gestiondestock.model.LigneCommandeFournisseur;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.repository.CommandeFournisseurRepository;
import com.agana.gestiondestock.repository.FournisseurRepository;
import com.agana.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.agana.gestiondestock.services.CommandeFournisseurService;
import com.agana.gestiondestock.validator.CommandeFournisseurValidator;
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
public class CommandeFournisuerServiceImpl implements CommandeFournisseurService {
    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
@Autowired
    public CommandeFournisuerServiceImpl(
            CommandeFournisseurRepository commandeFournisseurRepository,
            LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
            FournisseurRepository fournisseurRepository,ArticleRepository articleRepository)
    {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
        if (!errors.isEmpty()){
            log.error("Commande fournisseur n'est pas valide ");
            throw  new InvalidEntityException("", ErrorCodes.ORDER_PROVIDER_NOT_FOUND, errors);
        }
        //verifier si la commande existe dans la BD
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
        if (!fournisseur.isEmpty()){
            log.warn("Fournisseur whit ID is not found",commandeFournisseurDto.getFournisseur().getId());
            throw  new EntityNotFoundException("Aucun Fournisseur avec l'ID " + commandeFournisseurDto.getFournisseur().getId() + " n'a ete trouver dans la BD",
                    ErrorCodes.PROVIDER_NOT_FOUND);
        }
        //verifier chaque ligne des fourniseeur de la commande dans la BD
        List<String> articleErros = new ArrayList<>();
        if (commandeFournisseurDto.getLigneCommandeFournisseurs() != null){
            commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligCmdfour ->{
                if (ligCmdfour.getArticle() != null){
                    //verifier si l'article esxiste dans BD
                    Optional<Article> article = articleRepository.findById(ligCmdfour.getArticle().getId());
                    if (article.isEmpty()){
                        articleErros.add("L'article avec l' ID" + ligCmdfour.getArticle().getId() + " n'existe pas");
                    }
                }
                else {
                    articleErros.add("Veuillez selectionner  un article ");
                }
            });
        }
        if (!articleErros.isEmpty()){
            log.warn("L'article n'exsite pas dans la BD");
            throw  new InvalidEntityException("L'article n'exsite pas dans la BD", ErrorCodes.ARTICLE_NOT_FOUND, articleErros);

        }
        CommandeFournisseur savecmdfour = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));

        if (commandeFournisseurDto.getLigneCommandeFournisseurs() != null){
            commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligCmdfour ->{
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdfour);
                ligneCommandeFournisseur.setCommandeFournisseur(savecmdfour);
                //creer la commande
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }
        return CommandeFournisseurDto.fromEntity(savecmdfour);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null){
            log.error("Fournisseur  CODE is null");
            return null;
        }
        return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity).orElseThrow(() -> new EntityNotFoundException(
            "Aucune commande fournieur na ete trouve avec l'ID " +id, ErrorCodes.ORDER_PROVIDER_NOT_FOUND)
        );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Commande fournisseur CODE is null");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(CommandeFournisseurDto::fromEntity).orElseThrow(()-> new
                EntityNotFoundException( "Aucune commande fournieur na ete trouve avec le code " +code, ErrorCodes.ORDER_PROVIDER_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Fournisseur  ID is null");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
