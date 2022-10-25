/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Fornecedores;
import com.grupo04.sgpc.service.controller.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(Fornecedores fornecedor){
        return "/main/fornecedor/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Fornecedores fornecedor, RedirectAttributes attr){
        service.salvar(fornecedor);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("fornecedores", service.pesquisarTodos());
        return "main/fornecedor/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("fornecedores", service.pesquisarId(id));
        return "/main/fornecedor/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Fornecedores fornecedor){
        service.alterar(fornecedor);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
