/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.NotasEntradas;
import com.grupo04.sgpc.service.controller.NotaEntradaService;
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
public class NotaEntradaController {
    @Autowired
    private NotaEntradaService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(NotasEntradas notaEntrada){
        return "/main/notaentrada/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(NotasEntradas notaEntrada, RedirectAttributes attr){
        service.salvar(notaEntrada);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("notasentradas", service.pesquisarTodos());
        return "main/notaentrada/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("notasentradas", service.pesquisarId(id));
        return "/main/notaentrada/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(NotasEntradas notaEntrada){
        service.alterar(notaEntrada);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
