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
import com.projet.moneyManage.models.Depense;
import com.projet.moneyManage.services.DepenseService;
import com.projet.moneyManage.services.TypeDepenseService;
import com.projet.moneyManage.services.UtilisateurService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/depenses")
public class DepenseController {
    @Autowired
    private DepenseService depenseService;
    @Autowired
    private TypeDepenseService typeDepenseService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ModelAndView findAllByUtilisateur(HttpSession session ){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page", "depenses/depenses");
        try {
            Long idUtilisateur=(Long) session.getAttribute("utilisateurId");
            List<Depense> depenses=depenseService.findAllByUtilisateur(idUtilisateur);
            modelAndView.addObject("depenses", depenses);
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/add-form")
    public ModelAndView addForm(){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page", "depenses/ajout");
        modelAndView.addObject("types", typeDepenseService.findAll());
        return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView add(@RequestParam Double montant,@RequestParam LocalDateTime dateDepense,@RequestParam String raison,@RequestParam Long idTypeDepense,HttpSession session){
        ModelAndView modelAndView=new ModelAndView("template");
        try {
            Long idUtilisateur=(Long) session.getAttribute("utilisateurId");
            Depense depense=new Depense();
            depense.setMontant(montant);
            depense.setRaison(raison);
            depense.setDateDepense(dateDepense);
            depense.setTypeDepense(typeDepenseService.findById(idTypeDepense));
            depense.setUtilisateur(utilisateurService.findById(idUtilisateur));
            depenseService.saveDepense(depense);
            modelAndView.addObject("succes","Depense ajouté avec succes");
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        modelAndView.addObject("page","depenses/ajout");
        modelAndView.addObject("types", typeDepenseService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/depenses");
        try {
            Depense depense=depenseService.findById(id);
            depenseService.deleteDepense(depense);
        } catch (Exception e) {
            
            modelAndView.addObject("erreur", e.getMessage());
            modelAndView.setViewName("template");
            modelAndView.addObject("page","depenses/depenses");

        }
        return modelAndView;
    }


    @GetMapping("/update-form")
    public ModelAndView updateForm(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page","depenses/modifier");
        Depense depense=depenseService.findById(id);
        modelAndView.addObject("depense",depense);
        modelAndView.addObject("types", typeDepenseService.findAll());
        return modelAndView;
    }


    @PostMapping("/update")
    public ModelAndView update(@RequestParam Long idDepense,@RequestParam Double montant,@RequestParam LocalDateTime dateDepense,@RequestParam String raison,@RequestParam Long idTypeDepense ,HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("template");
        try {
            Long idUtilisateur=(Long) httpSession.getAttribute("utilisateurId");
            Depense depense=new Depense();
            depense.setIdDepense(idDepense);
            depense.setMontant(montant);
            depense.setRaison(raison);
            depense.setDateDepense(dateDepense);
            depense.setTypeDepense(typeDepenseService.findById(idTypeDepense));
            depense.setUtilisateur(utilisateurService.findById(idUtilisateur));
            depenseService.saveDepense(depense);
            modelAndView.addObject("succes","Depense modifier avec succes");
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        modelAndView.addObject("depense", depenseService.findById(idDepense));
        modelAndView.addObject("page","depenses/modifier");
        modelAndView.addObject("types", typeDepenseService.findAll());
        return modelAndView;
    }
}

