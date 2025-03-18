package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Revenu;
import com.projet.moneyManage.models.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenuRepository extends JpaRepository<Revenu, Long> {
    public List<Revenu> findAllByUtilisateur(Utilisateur utilisateur);
}
