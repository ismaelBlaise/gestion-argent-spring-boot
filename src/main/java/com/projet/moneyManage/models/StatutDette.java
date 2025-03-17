package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "statuts_dette")
public class StatutDette {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_statut")
    private Long idStatut;

    private String nom;

    @OneToMany(mappedBy = "statut")
    private Set<Dette> dettes;
}
