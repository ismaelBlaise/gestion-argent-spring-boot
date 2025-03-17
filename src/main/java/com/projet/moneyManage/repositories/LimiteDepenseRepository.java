package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.LimiteDepense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteDepenseRepository extends JpaRepository<LimiteDepense, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
