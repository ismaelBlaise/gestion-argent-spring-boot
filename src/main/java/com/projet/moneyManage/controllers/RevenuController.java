package com.projet.moneyManage.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.moneyManage.models.Revenu;
import com.projet.moneyManage.services.RevenuService;
import com.projet.moneyManage.services.TypeRevenuService;
import com.projet.moneyManage.services.UtilisateurService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/revenus")
public class RevenuController {
    @Autowired 
    private RevenuService revenuService;

    @Autowired
    private TypeRevenuService typeRevenuService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ModelAndView findAllByUtilisateur(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page", "revenus/revenus");
        try {
            Long idUtilisateur=(Long) httpSession.getAttribute("utilisateurId");
            List<Revenu> revenus=revenuService.findAllByUtilisateur(idUtilisateur);
            modelAndView.addObject("revenus", revenus);
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        return modelAndView;
    }


    @GetMapping("/add-form")
    public ModelAndView addForm(){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page","revenus/ajout");
        modelAndView.addObject("types", typeRevenuService.findAll());
        return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView add(@RequestParam Double montant,@RequestParam LocalDateTime dateRevenu,@RequestParam Long idTypeRevenu ,HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("template");
        try {
            Long idUtilisateur=(Long) httpSession.getAttribute("utilisateurId");
            Revenu revenu=new Revenu();
            revenu.setMontant(montant);
            revenu.setDateRevenu(dateRevenu);
            revenu.setTypeRevenu(typeRevenuService.findById(idTypeRevenu));
            revenu.setUtilisateur(utilisateurService.findById(idUtilisateur));
            revenuService.saveRevenu(revenu);
            modelAndView.addObject("succes","Revenu ajouté avec succes");
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        modelAndView.addObject("page","revenus/ajout");
        modelAndView.addObject("types", typeRevenuService.findAll());
        return modelAndView;
    }


    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/revenus");
        try {
            Revenu revenu=revenuService.findById(id);
            revenuService.deleteRevenu(revenu);
        } catch (Exception e) {
            
            modelAndView.addObject("erreur", e.getMessage());
            modelAndView.setViewName("template");
            modelAndView.addObject("page","revenus/revenus");

        }
        return modelAndView;
    }

    @GetMapping("/update-form")
    public ModelAndView updateForm(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page","revenus/modifier");
        Revenu revenu=revenuService.findById(id);
        modelAndView.addObject("revenu", revenu);
        modelAndView.addObject("types", typeRevenuService.findAll());
        return modelAndView;
    }


    @PostMapping("/update")
    public ModelAndView update(@RequestParam Long idRevenu,@RequestParam Double montant,@RequestParam LocalDateTime dateRevenu,@RequestParam Long idTypeRevenu ,HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("template");
        try {
            Long idUtilisateur=(Long) httpSession.getAttribute("utilisateurId");
            Revenu revenu=new Revenu();
            revenu.setIdRevenu(idRevenu);
            revenu.setMontant(montant);
            revenu.setDateRevenu(dateRevenu);
            revenu.setTypeRevenu(typeRevenuService.findById(idTypeRevenu));
            revenu.setUtilisateur(utilisateurService.findById(idUtilisateur));
            revenuService.saveRevenu(revenu);
            modelAndView.addObject("succes","Revenu modifier avec succes");
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        modelAndView.addObject("revenu", revenuService.findById(idRevenu));
        modelAndView.addObject("page","revenus/modifier");
        modelAndView.addObject("types", typeRevenuService.findAll());
        return modelAndView;
    }
}
