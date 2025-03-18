package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.Depense;
import com.projet.moneyManage.models.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {
    public List<Depense> findAllByUtilisateur(Utilisateur utilisateur);
}
