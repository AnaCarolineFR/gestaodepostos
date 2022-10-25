/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.FretesTipos;
import com.grupo04.sgpc.service.controller.FreteTipoService;
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
public class FreteTipoController {
    
    @Autowired
    private FreteTipoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(FretesTipos freteTipo){
        return "/main/fretetipo/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(FretesTipos freteTipo, RedirectAttributes attr){
        service.salvar(freteTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("fretestipos", service.pesquisarTodos());
        return "main/fretetipo/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("fretestipos", service.pesquisarId(id));
        return "/main/fretetipo/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(FretesTipos freteTipo){
        service.alterar(freteTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
