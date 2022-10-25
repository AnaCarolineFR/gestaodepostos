/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.CondicoesPagamentos;
import com.grupo04.sgpc.service.controller.CondicaoPagamentoService;
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
public class CondicaoPagamentoController {
    
    @Autowired
    private CondicaoPagamentoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(CondicoesPagamentos condicaoPagamento){
        return "/main/condicaopagamento/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(CondicoesPagamentos condicaoPagamento, RedirectAttributes attr){
        service.salvar(condicaoPagamento);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("condicoespagamentos", service.pesquisarTodos());
        return "main/condicaopagamento/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("condicoespagamentos", service.pesquisarId(id));
        return "/main/condicaopagamento/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(CondicoesPagamentos condicaoPagamento){
        service.alterar(condicaoPagamento);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
