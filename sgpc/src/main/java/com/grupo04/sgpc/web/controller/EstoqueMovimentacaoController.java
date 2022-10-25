/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.EstoquesMovimentacoes;
import com.grupo04.sgpc.service.controller.EstoqueMovimentacaoService;
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
public class EstoqueMovimentacaoController {
    
    @Autowired
    private EstoqueMovimentacaoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(EstoquesMovimentacoes estoqueMovimentacao){
        return "/main/estoquemovimentacao/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(EstoquesMovimentacoes estoqueMovimentacao, RedirectAttributes attr){
        service.salvar(estoqueMovimentacao);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("estoquesmovimentacoes", service.pesquisarTodos());
        return "main/estoquemovimentacao/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("estoquesmovimentacoes", service.pesquisarId(id));
        return "/main/estoquemovimentacao/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(EstoquesMovimentacoes estoqueMovimentacao){
        service.alterar(estoqueMovimentacao);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
