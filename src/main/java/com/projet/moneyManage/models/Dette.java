package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "dettes")
public class Dette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dette")
    private Long idDette;

    private Double montant;

    private String raison;

    private String personne;

    private LocalDateTime dateDebut;

    private LocalDateTime dateLimite;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_statut")
    private StatutDette statut;

    @ManyToOne
    @JoinColumn(name = "id_type_dette")
    private TypeDette typeDette;
}
