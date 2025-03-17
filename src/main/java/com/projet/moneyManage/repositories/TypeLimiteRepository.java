package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.TypeLimite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLimiteRepository extends JpaRepository<TypeLimite, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
