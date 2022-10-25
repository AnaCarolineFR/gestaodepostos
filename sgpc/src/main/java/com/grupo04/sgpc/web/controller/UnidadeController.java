/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Unidades;
import com.grupo04.sgpc.service.controller.UnidadeService;
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
@RequestMapping("/unidades")
public class UnidadeController {
    
    @Autowired
    private UnidadeService serviceUnidade;
    
    @GetMapping("cadastrar")
    public String cadastrar(Unidades unidade){
        return "/main/unidade/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Unidades unidade, RedirectAttributes attr){
        serviceUnidade.salvar(unidade);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("unidades", serviceUnidade.pesquisarTodos());
        return "main/unidade/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("unidades", serviceUnidade.pesquisarId(id));
        return "/main/unidade/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Unidades unidade){
        serviceUnidade.alterar(unidade);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        serviceUnidade.excluir(id);
        return "redirect:listar";
    }
}
