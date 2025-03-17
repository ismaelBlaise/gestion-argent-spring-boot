package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.TypeDette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDetteRepository extends JpaRepository<TypeDette, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
