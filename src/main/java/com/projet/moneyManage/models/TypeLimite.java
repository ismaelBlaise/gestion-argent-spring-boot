package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "types_limite")
public class TypeLimite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_limite")
    private Long idTypeLimite;

    private String nom;

    @OneToMany(mappedBy = "typeLimite")
    private Set<LimiteDepense> limitesDepense;
}
