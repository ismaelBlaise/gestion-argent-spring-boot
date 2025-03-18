package com.projet.moneyManage.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DepenseRevenuId implements Serializable {
    private Long typeRevenu;  // Correspond à id_type_revenu
    private Long typeDepense; // Correspond à id_type_depense
}
