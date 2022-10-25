/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.FornecedoresTipos;
import com.grupo04.sgpc.service.controller.FornecedorTipoService;
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
public class FornecedorTipoController {
    
    @Autowired
    private FornecedorTipoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(FornecedoresTipos fornecedorTipo){
        return "/main/fornecedortipo/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(FornecedoresTipos fornecedorTipo, RedirectAttributes attr){
        service.salvar(fornecedorTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("fornecedorestipos", service.pesquisarTodos());
        return "main/fornecedortipo/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("fornecedorestipos", service.pesquisarId(id));
        return "/main/fornecedortipo/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(FornecedoresTipos fornecedorTipo){
        service.alterar(fornecedorTipo);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
