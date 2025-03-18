package com.projet.moneyManage.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    @PostMapping("/login")
    public ModelAndView login(@Param){
        
    }
}
