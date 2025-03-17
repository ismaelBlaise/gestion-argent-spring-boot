package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
