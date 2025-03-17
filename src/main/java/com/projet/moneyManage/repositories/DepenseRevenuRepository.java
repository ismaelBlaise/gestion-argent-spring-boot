package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.DepenseRevenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRevenuRepository extends JpaRepository<DepenseRevenu, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
