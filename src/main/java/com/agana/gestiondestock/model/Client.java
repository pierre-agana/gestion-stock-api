package com.agana.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "client")
public class Client extends AbstractEntity{

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @Embedded
    private Adresse adress;

    @Column(name = "picture")
    private String picture;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "client")  
    private List<CommandeClient> commandeClients;
}
