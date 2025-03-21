package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Dette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetteRepository extends JpaRepository<Dette, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
