/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Empresas;
import com.grupo04.sgpc.service.controller.EmpresaService;
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
@RequestMapping("/empresas")
public class EmpresaController {
    
    @Autowired
    private EmpresaService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(Empresas empresa){
        return "/main/empresa/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Empresas empresa, RedirectAttributes attr){
        service.salvar(empresa);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("empresas", service.pesquisarTodos());
        return "main/empresa/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("empresas", service.pesquisarId(id));
        return "/main/empresa/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Empresas empresa){
        service.alterar(empresa);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
