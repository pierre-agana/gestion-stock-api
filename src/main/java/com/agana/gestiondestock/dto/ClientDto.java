package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Adresse;
import com.agana.gestiondestock.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private Integer idEntreprise;

    private Adresse adress;

    private String picture;

    private String email;

    private String phone;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    //mapping de Client -> ClientDto
    public  ClientDto fromEntity(Client client) {
        if (client == null){
            return null;

            // TODO throw and exception
        }
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .adress(client.getAdress())
                .picture(client.getPicture())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }

    //mapping de ClientDto -> Client
    public Client toEntity(ClientDto clientDto) {
        if (clientDto == null){
            return null;

            // TODO throw and exception
        }

        //mapping de ClientDto -> Client
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setAdress(clientDto.getAdress());
        client.setPicture(clientDto.getPicture());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());

        return client;
    }
}
