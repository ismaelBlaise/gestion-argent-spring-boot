package com.projet.moneyManage.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "depense_revenu")
public class DepenseRevenu {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_type_revenu")
    private TypeRevenu typeRevenu;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;
}
