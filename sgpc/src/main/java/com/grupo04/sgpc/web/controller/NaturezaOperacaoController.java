/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.NaturezasOperacoes;
import com.grupo04.sgpc.service.controller.NaturezaOperacaoService;
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
@RequestMapping("/naturezasoperacoes")
public class NaturezaOperacaoController {
    
    @Autowired
    private NaturezaOperacaoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(NaturezasOperacoes naturezaOperacao){
        return "/main/naturezaoperacao/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(NaturezasOperacoes naturezaOperacao, RedirectAttributes attr){
        service.salvar(naturezaOperacao);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("naturezasoperacoes", service.pesquisarTodos());
        return "main/naturezaoperacao/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("naturezasoperacoes", service.pesquisarId(id));
        return "/main/naturezaoperacao/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(NaturezasOperacoes naturezaOperacao){
        service.alterar(naturezaOperacao);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
    
}
