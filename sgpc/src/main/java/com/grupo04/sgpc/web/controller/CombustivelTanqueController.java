/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import com.grupo04.sgpc.service.controller.CombustivelTanqueService;
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
public class CombustivelTanqueController {
    
    @Autowired
    private CombustivelTanqueService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(CombustiveisTanques combustivelTanque){
        return "/main/combustiveltanque/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(CombustiveisTanques combustivelTanque, RedirectAttributes attr){
        service.salvar(combustivelTanque);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("combustiveistanques", service.pesquisarTodos());
        return "main/combustiveltanque/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("combustiveistanques", service.pesquisarId(id));
        return "/main/combustiveltanque/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(CombustiveisTanques combustivelTanque){
        service.alterar(combustivelTanque);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
