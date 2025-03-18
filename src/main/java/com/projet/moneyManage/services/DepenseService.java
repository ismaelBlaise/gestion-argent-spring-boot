package com.projet.moneyManage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.Depense;
import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.repositories.DepenseRepository;
import com.projet.moneyManage.repositories.UtilisateurRepository;

@Service
public class DepenseService {
    @Autowired
    private DepenseRepository depenseRepository;


    @Autowired
    private UtilisateurRepository utilisateurRepository;


    public List<Depense> findAllByUtilisateur(Long utilisateurId) throws Exception{
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(utilisateurId);
        if(utilisateur.isPresent()==false){
            throw new Exception("Aucun utilisateur connecté");
        }
        return depenseRepository.findAllByUtilisateur(utilisateur.get());   
    }
}
