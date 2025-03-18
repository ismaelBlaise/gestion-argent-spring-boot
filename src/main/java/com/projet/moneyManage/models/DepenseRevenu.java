package com.projet.moneyManage.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "depense_revenu")
public class DepenseRevenu {

    @EmbeddedId
    private DepenseRevenuId id;

    @ManyToOne
    @MapsId("typeRevenu")
    @JoinColumn(name = "id_type_revenu")
    private TypeRevenu typeRevenu;

    @ManyToOne
    @MapsId("typeDepense")
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;
}
