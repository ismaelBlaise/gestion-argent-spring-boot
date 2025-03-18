package com.projet.moneyManage.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public Utilisateur login(String email,String motDePasse) throws Exception{
        Optional<Utilisateur> utilisateur=utilisateurRepository.findByEmail(email);
        if(utilisateur.isPresent()){
            Utilisateur utilisateur2=utilisateur.get();
            if(bCryptPasswordEncoder.matches(email, motDePasse)){
                return utilisateur2;
                
            }
            else {
                throw new Exception("Mot de passe incorrect");
            }
        }
        else{
            throw new Exception("Adresse email introuvable");
        }
    } 


    public void signup(String nom,String email,String motDePasse) throws  Exception{
        Optional<Utilisateur> utilisateur=utilisateurRepository.findByEmail(email);
        if(utilisateur.isPresent()){
            Utilisateur utilisateur1=new Utilisateur();
            utilisateur1.setNom(nom);
            utilisateur1.setEmail(email);
            utilisateur1.setMotDePasse(motDePasse);
            utilisateurRepository.save(utilisateur1);

        }else{
            throw new Exception("Adresse email deja utilisé");
        }
    }
}
