/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisLivros;
import com.grupo04.sgpc.service.controller.CombustivelLivroService;
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
public class CombustivelLivroController {
    
    @Autowired
    private CombustivelLivroService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(CombustiveisLivros combustivelLivro){
        return "/main/combustivellivro/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(CombustiveisLivros combustivelLivro, RedirectAttributes attr){
        service.salvar(combustivelLivro);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("combustiveislivros", service.pesquisarTodos());
        return "main/combustivellivro/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("combustiveislivros", service.pesquisarId(id));
        return "/main/combustivellivro/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(CombustiveisLivros combustivelLivro){
        service.alterar(combustivelLivro);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
