package com.projet.moneyManage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projet.moneyManage.models.Dette;
import com.projet.moneyManage.services.DetteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettes")
public class DetteController {
    @Autowired 
    private DetteService  detteService;
    
    @GetMapping
    public ModelAndView findAllByUtilisateur(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("template");
        modelAndView.addObject("page", "dettes/dettes");
        try {
            Long idUtilisateur=(Long) session.getAttribute("utilisateurId");
            List<Dette> dettes=detteService.findAllByUtilisateur(idUtilisateur);
            modelAndView.addObject("dettes", dettes);
        } catch (Exception e) {
            modelAndView.addObject("erreur",e.getMessage());
        }
        return modelAndView;
    } 
}
