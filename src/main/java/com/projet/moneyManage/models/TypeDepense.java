package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "types_depense")
public class TypeDepense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_depense")
    private Long idTypeDepense;

    private String nom;

    @OneToMany(mappedBy = "typeDepense")
    private Set<Depense> depenses;
}
