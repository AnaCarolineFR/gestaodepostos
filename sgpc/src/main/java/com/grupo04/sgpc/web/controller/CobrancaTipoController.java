/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.CobrancasTipos;
import com.grupo04.sgpc.service.controller.CobrancaTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rafael-d
 */

@Controller
@RequestMapping("/cobrancas")
public class CobrancaTipoController {
    
    @Autowired
    private CobrancaTipoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(CobrancasTipos cobrancaTipo){
        return "/main/cobranca/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(CobrancasTipos cobrancaTipo, RedirectAttributes attr){
        service.salvar(cobrancaTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("cobrancasTipos", service.pesquisarTodos());
        return "main/cobrancatipo/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cobrancasTipos", service.pesquisarId(id));
        return "/main/cobrancatipo/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(CobrancasTipos cobrancaTipo){
        service.alterar(cobrancaTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
    
}
