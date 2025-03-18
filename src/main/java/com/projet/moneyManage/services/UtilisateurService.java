package com.projet.moneyManage.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // @Autowired
    // private ByCryp

    public Utilisateur login(String email,String motDePasse) throws Exception{
        Optional<Utilisateur> utilisateur=utilisateurRepository.findByEmail(email);
        if(utilisateur.isPresent()){
            Utilisateur utilisateur2=utilisateur.get();
            if(utilisateur2.equals(motDePasse)){

            }
            return utilisateur2;
        }
        else{

        }
    } 
}
