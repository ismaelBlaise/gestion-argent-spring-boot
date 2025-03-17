package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "types_dette")
public class TypeDette {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_type_dette")
    private Long idTypeDette;

    private String nom;

    @OneToMany(mappedBy = "typeDette")
    private Set<Dette> dettes;
}
