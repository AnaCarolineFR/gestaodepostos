/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Clientes;
import com.grupo04.sgpc.service.controller.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(Clientes cliente){
        return "/main/cliente/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Clientes cliente, RedirectAttributes attr){
        service.salvar(cliente);
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("clientes", service.pesquisarTodos());
        return "main/almoxarifado/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("clientes", service.pesquisarId(id));
        return "/main/cliente/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Clientes cliente){
        service.alterar(cliente);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        service.excluir(id);
        return "redirect:listar";
    }
}
