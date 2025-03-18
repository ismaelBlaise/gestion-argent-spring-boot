package com.projet.moneyManage.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.moneyManage.models.Utilisateur;
import com.projet.moneyManage.services.UtilisateurService;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String mdp, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("template");
        
        try {
            Utilisateur utilisateur = utilisateurService.login(email, mdp);
            
            session.setAttribute("utilisateurId", utilisateur.getIdUtilisateur());
            modelAndView.addObject("page", "pages/accueil");
        } catch (Exception e) {
            modelAndView.setViewName("index");
            modelAndView.addObject("erreur", e.getMessage());
        }

        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView signup(@RequestParam String nom,@RequestParam String email,@RequestParam String mdp){
        ModelAndView modelAndView = new ModelAndView("signup");
        try {
            utilisateurService.signup(nom, email, mdp);
            modelAndView.addObject("succes", "inscription reussi");
        }catch (Exception e) {
            modelAndView.addObject("erreur", e.getMessage());
        }

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession){
        httpSession.invalidate();
        ModelAndView modelAndView=new ModelAndView("redirect:/");
        
        return modelAndView;
    }
}
