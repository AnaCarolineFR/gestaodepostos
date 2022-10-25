/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author rafael-d
 */

@Controller
public class IndexController {
    
    
    
    @GetMapping("/")
    public String index(){
        return "/index";
    }
    
    @GetMapping({"/login"})
    public String login(){
        return "/index";
    }
    
    @GetMapping({"/login-error"})
    public String loginError(ModelMap model){
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Acesso Negado!" );
        model.addAttribute("texto", "Usuário ou senha incorreta, tente novamente!");
        model.addAttribute("subtexto", "Para acessar o sistema você deverá possuir um usuário e uma senha válida.");
        return "/index";
    }
    
}
