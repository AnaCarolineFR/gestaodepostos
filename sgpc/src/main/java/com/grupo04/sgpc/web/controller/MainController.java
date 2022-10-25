/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author rafael-d
 */

@Controller
public class MainController {
    
    /********************************************************************
    * Não alterar. Se presicsar comente...mas não modifique, nem exclua!*
    ********************************************************************/
    @GetMapping("main")
    public String main(){
        return "main/main";
    }

    @GetMapping("cadastros")
    public String cadastros(){
        return "main/cadastros";
    }
    
    @GetMapping("pesquisas")
    public String pesquisas(){
        return "main/pesquisas";
    }
    
    @GetMapping("lojas")
    public String lojas(){
        return "main/lojas";
    }
    
    @GetMapping("pistas")
    public String pistas(){
        return "main/pistas";
    }
    
    
}
