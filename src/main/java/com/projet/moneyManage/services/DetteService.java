package com.projet.moneyManage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.moneyManage.models.Dette;
import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.repositories.DetteRepository;
import com.projet.moneyManage.repositories.UtilisateurRepository;

@Service
public class DetteService {
    @Autowired
    private DetteRepository detteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

     public List<Dette> findAllByUtilisateur(Long utilisateurId) throws Exception{
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(utilisateurId);
        if(utilisateur.isPresent()==false){
            throw new Exception("Aucun utilisateur connecté");
        }
        return detteRepository.findAllByUtilisateur(utilisateur.get());   
    }
}
