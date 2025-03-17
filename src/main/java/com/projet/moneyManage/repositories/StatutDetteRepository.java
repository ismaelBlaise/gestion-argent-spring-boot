package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.StatutDette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDetteRepository extends JpaRepository<StatutDette, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
