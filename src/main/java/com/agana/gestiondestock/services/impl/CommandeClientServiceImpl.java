package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.CommandeClientDto;
import com.agana.gestiondestock.dto.LigneCommandeClientDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.Client;
import com.agana.gestiondestock.model.CommandeClient;
import com.agana.gestiondestock.model.LigneCommandeClient;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.repository.ClientRepository;
import com.agana.gestiondestock.repository.CommandeClientRepository;
import com.agana.gestiondestock.repository.LigneCommandeClientRepository;
import com.agana.gestiondestock.services.CommandeClientService;
import com.agana.gestiondestock.validator.CommandeClientValidator;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,
                                     ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository){
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }
    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> errors = CommandeClientValidator.validate(commandeClientDto);
        if (!errors.isEmpty()){
            log.error("Commande client n'est pas valide ");
            throw  new InvalidEntityException("", ErrorCodes.ORDER_CUSTOMER_NOT_VALID, errors);
        }
        //verifier si le client existe dans la BD
        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
        if (!client.isEmpty()){
            log.warn("Client whit ID is not found",commandeClientDto.getClient().getId());
            throw  new EntityNotFoundException("Aucun client avec l'ID " + commandeClientDto.getClient().getId() + " n'a ete trouver dans la BD");
        }
        //verifier chaque ligne des article de la commande dans la BD
        List<String> articleErros = new ArrayList<>();
         if (commandeClientDto.getLigneCommandeClients() != null){
             //recupere les articles de la commande
             commandeClientDto.getLigneCommandeClients().forEach(ligCmdClt ->{
                 if (ligCmdClt.getArticle() != null){
                     //verifier si l'article esxiste dans BD
                     Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                     if (article.isEmpty()){
                         articleErros.add("L'article avec l' ID" + ligCmdClt.getArticle().getId() + " n'existe pas");
                     }
                 }else {
                     articleErros.add("Veuillez selectionner  un article ");
                 }
             });
         }

         if (!articleErros.isEmpty()){
             log.warn("L'article n'exsite pas dans la BD");
             throw  new InvalidEntityException("L'article n'exsite pas dans la BD", ErrorCodes.ARTICLE_NOT_FOUND, articleErros);

         }

        CommandeClient savecmdclt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));

        if (commandeClientDto.getLigneCommandeClients() != null) {
            commandeClientDto.getLigneCommandeClients().forEach(ligcmdclt -> {
                //creer les ligne de commande client
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligcmdclt);
                ligneCommandeClient.setCommandeClient(savecmdclt);
                //creer la commande
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(savecmdclt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null){
            log.error("Commande client ID is null");
            return null;
        }
        return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException(
                "Aucune commande na ete trouve avec l'ID " +id, ErrorCodes.ORDER_CUSTOMER_NOT_FOUND)
        );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Commande CODE is null");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException(
                "Aucune commande na ete trouve avec le CODE " +code, ErrorCodes.ORDER_CUSTOMER_NOT_FOUND)
        );
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Commande ID is null");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
