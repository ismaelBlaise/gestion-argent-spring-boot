package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.TypeRevenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRevenuRepository extends JpaRepository<TypeRevenu, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
