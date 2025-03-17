package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "depenses")
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_depense")
    private Long idDepense;

    private Double montant;

    private String raison;

    private LocalDateTime dateDepense;

    @ManyToOne
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
