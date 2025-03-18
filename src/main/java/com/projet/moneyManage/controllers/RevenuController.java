package com.projet.moneyManage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projet.moneyManage.models.Revenu;
import com.projet.moneyManage.services.RevenuService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/revenus")
public class RevenuController {
    @Autowired 
    private RevenuService revenuService;

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
}
