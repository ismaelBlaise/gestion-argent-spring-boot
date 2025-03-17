package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "types_revenu")
public class TypeRevenu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_type_revenu")
    private Long idTypeRevenu;

    private String nom;

    @OneToMany(mappedBy = "typeRevenu")
    private Set<Revenu> revenus;
}
