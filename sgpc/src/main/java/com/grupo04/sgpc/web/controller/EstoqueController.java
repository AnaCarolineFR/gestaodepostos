/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Estoques;
import com.grupo04.sgpc.service.controller.EstoqueService;
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
public class EstoqueController {
    
    @Autowired
    private EstoqueService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(Estoques estoque){
        return "/main/estoque/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Estoques estoque, RedirectAttributes attr){
        service.salvar(estoque);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("estoques", service.pesquisarTodos());
        return "main/estoque/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("estoque", service.pesquisarId(id));
        return "/main/estoque/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Estoques estoque){
        service.alterar(estoque);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
    
}
