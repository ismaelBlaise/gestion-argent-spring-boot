package com.projet.moneyManage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }
}
