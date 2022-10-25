/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Almoxarifados;
import com.grupo04.sgpc.service.controller.AlmoxarifadoService;
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
@RequestMapping("/almoxarifados")
public class AlmoxarifadoController {
    
    @Autowired
    private AlmoxarifadoService service;
    
    @GetMapping("cadastrar")
    public String cadastrar(Almoxarifados almoxarifado){
        return "/main/almoxarifado/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Almoxarifados almoxarifado, RedirectAttributes attr){
        service.salvar(almoxarifado);
        attr.addFlashAttribute("success", "Inclusão realizada com sucesso!");
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("almoxarifados", service.pesquisarTodos());
        return "main/almoxarifado/cadastro";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("almoxarifados", service.pesquisarId(id));
        return "/main/almoxarifado/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Almoxarifados almoxarifado){
        service.alterar(almoxarifado);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
         if(service.Almoxarifados(id)){
            model.addAttribute("fail", "Falha ao tentar realizar a exclusão do registro!");
        }else{
        service.excluir(id);
        model.addAttribute("success", "Exclusão realizada com sucesso!");
        }
        return listar(model);
    }
    
    
    
    
    
}
