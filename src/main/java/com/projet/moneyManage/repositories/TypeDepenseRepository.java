package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.TypeDepense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDepenseRepository extends JpaRepository<TypeDepense, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
