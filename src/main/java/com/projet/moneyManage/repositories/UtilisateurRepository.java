package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
