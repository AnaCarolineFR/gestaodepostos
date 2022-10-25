/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.TitulosPagar;
import com.grupo04.sgpc.service.controller.TituloPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rafael-d
 */
public class TituloPagarController {
    
    @Autowired
    private TituloPagarService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(TitulosPagar tituloPagar){
        return "/main/titulopagar/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(TitulosPagar tituloPagar, RedirectAttributes attr){
        service.salvar(tituloPagar);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("titulospagar", service.pesquisarTodos());
        return "main/titulopagar/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("titulospagar", service.pesquisarId(id));
        return "/main/titulopagar/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(TitulosPagar tituloPagar){
        service.alterar(tituloPagar);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
