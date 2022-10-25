/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rafael-d
 */

@Controller
@RequestMapping("/lojas")
public class VendaConveniencia {
    
    @GetMapping("venda")
    public String venda(){
        return "main/loja/venda";
    }
    
}
