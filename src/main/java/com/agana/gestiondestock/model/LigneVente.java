package com.agana.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes ventes;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
