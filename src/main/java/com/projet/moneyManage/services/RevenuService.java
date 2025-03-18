package com.projet.moneyManage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.Revenu;
import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.repositories.RevenuRepository;
import com.projet.moneyManage.repositories.UtilisateurRepository;

@Service
public class RevenuService {
    @Autowired
    private RevenuRepository revenuRepository;

    @Autowired UtilisateurRepository utilisateurRepository;

    public List<Revenu> findAllByUtilisateur(Long idUtilisateur) throws Exception{

        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(idUtilisateur);
        if(utilisateur.isPresent()==false){
            throw new Exception("Aucun utilisateur connecté");
        }
        return revenuRepository.findAllByUtilisateur(utilisateur.get());
    }
}
