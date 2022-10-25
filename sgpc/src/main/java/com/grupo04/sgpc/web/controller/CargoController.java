/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Cargos;
import com.grupo04.sgpc.service.controller.CargoService;
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
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoService service;
    
    /********************************************************************
    * Não alterar. Se presicsar comente...mas não modifique, nem exclua!*
    ********************************************************************/
//    @GetMapping("cadastrar")
//    public String cadastrar(Cargos cargo){
//        return "/main/cargo/cadastro";
//    }
    
    @GetMapping("cadastrar")
    public String cadastrar(Cargos cargo){
        return "/main/cargo/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Cargos cargo, RedirectAttributes attr){
        service.salvar(cargo);
        attr.addFlashAttribute("success", "Inclusão realizada com sucesso!");
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("cargos", service.pesquisarTodos());
        return "/main/cargo/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargos", service.pesquisarId(id));
        return "/main/cargo/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Cargos cargo, RedirectAttributes attr){
        service.alterar(cargo);
        attr.addFlashAttribute("success", "Alteração realizada com sucesso!");
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if(service.usuarioCargos(id)){
            model.addAttribute("fail", "Falha ao tentar realizar a exclusão do registro!");
        }else{
            service.excluir(id);
            model.addAttribute("success", "Exclusão realizada com sucesso!");
        }
        return listar(model);
    }
}
