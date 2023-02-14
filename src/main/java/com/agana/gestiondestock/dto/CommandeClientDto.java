package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Client;
import com.agana.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {

    private Integer id;
    private String code;
    private Instant dateCommande;
    private Integer idEntreprise;
    private Client client;


    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null){
            return null;

            // TODO throw and exception
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .idEntreprise(commandeClient.getIdEntreprise())
                .client(commandeClient.getClient())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null){
            return null;

            // TODO throw and exception
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setClient(commandeClientDto.getClient());

        return commandeClient;
    }
}
