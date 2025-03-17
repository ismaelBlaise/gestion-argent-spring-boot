package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "revenus")
public class Revenu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_revenu")
    private Long idRevenu;

    private Double montant;

    private LocalDateTime dateRevenu;

    @ManyToOne
    @JoinColumn(name = "id_type_revenu")
    private TypeRevenu typeRevenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
