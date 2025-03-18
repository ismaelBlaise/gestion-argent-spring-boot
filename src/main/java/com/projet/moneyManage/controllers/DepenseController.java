package com.projet.moneyManage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projet.moneyManage.models.Depense;
import com.projet.moneyManage.services.DepenseService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/depenses")
public class DepenseController {
    @Autowired
    private DepenseService depenseService;

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
}
