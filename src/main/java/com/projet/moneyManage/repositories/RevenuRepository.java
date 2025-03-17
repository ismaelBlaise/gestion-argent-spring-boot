package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Revenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenuRepository extends JpaRepository<Revenu, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
