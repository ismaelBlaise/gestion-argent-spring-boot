package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "statuts_dette")
public class StatutDette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statut")
    private Long idStatut;

    private String nom;

    @OneToMany(mappedBy = "statut")
    private Set<Dette> dettes;
}
