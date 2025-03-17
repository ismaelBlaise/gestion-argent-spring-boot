package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "limites_depense")
public class LimiteDepense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_limite_depense")
    private Long idLimiteDepense;

    private Double montant;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_type_limite")
    private TypeLimite typeLimite;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
