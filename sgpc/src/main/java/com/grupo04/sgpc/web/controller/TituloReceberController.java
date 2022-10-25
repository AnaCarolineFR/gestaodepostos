/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.TitulosReceber;
import com.grupo04.sgpc.service.controller.TituloReceberService;
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
public class TituloReceberController {
    
    @Autowired
    private TituloReceberService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(TitulosReceber tituloReceber){
        return "/main/tituloreceber/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(TitulosReceber tituloReceber, RedirectAttributes attr){
        service.salvar(tituloReceber);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("titulosreceber", service.pesquisarTodos());
        return "main/tituloreceber/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("titulosreceber", service.pesquisarId(id));
        return "/main/tituloreceber/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(TitulosReceber tituloReceber){
        service.alterar(tituloReceber);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
