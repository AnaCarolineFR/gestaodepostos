/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.NotasSaidas;
import com.grupo04.sgpc.service.controller.NotaSaidaService;
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
public class NotaSaidaController {
    
    @Autowired
    private NotaSaidaService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(NotasSaidas notaSaida){
        return "/main/notasaida/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(NotasSaidas notaSaida, RedirectAttributes attr){
        service.salvar(notaSaida);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("notassaidas", service.pesquisarTodos());
        return "main/notasaida/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("notassaidas", service.pesquisarId(id));
        return "/main/notasaida/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(NotasSaidas notaSaida){
        service.alterar(notaSaida);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
