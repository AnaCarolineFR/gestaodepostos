/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.TitulosTipos;
import com.grupo04.sgpc.service.controller.TituloTipoService;
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
public class TituloTipoController {
    
    @Autowired
    private TituloTipoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(TitulosTipos tituloTipo){
        return "/main/titulotipo/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(TitulosTipos tituloTipo, RedirectAttributes attr){
        service.salvar(tituloTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("titulostipos", service.pesquisarTodos());
        return "main/titulotipo/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("titulostipos", service.pesquisarId(id));
        return "/main/titulotipo/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(TitulosTipos tituloTipo){
        service.alterar(tituloTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
