package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    private String nom;

    private String email;

    private String motDePasse;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Revenu> revenus;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Depense> depenses;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Dette> dettes;

    @OneToMany(mappedBy = "utilisateur")
    private Set<LimiteDepense> limitesDepense;
}
