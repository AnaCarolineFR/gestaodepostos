/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.domain.controller.Cargos;
import com.grupo04.sgpc.domain.controller.Empresas;
import com.grupo04.sgpc.domain.controller.Usuarios;
import com.grupo04.sgpc.service.controller.CargoService;
import com.grupo04.sgpc.service.controller.EmpresaService;
import com.grupo04.sgpc.service.controller.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rafael-d
 */

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService serviceUsuario;
    
    @Autowired
    private CargoService serviceCargo;
    
    @Autowired
    private EmpresaService serviceEmpresa;
    
    @GetMapping("cadastrar")
    public String cadastrar(Usuarios usuario){
        return "main/usuario/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Usuarios usuario, RedirectAttributes attr){
        try{
            if(!usuario.getNomeUsuario().isEmpty()){
                if(usuario.getSenhaUsuario().equals(usuario.getSenhaConfirmaUsuario())){
                    usuario.setSenhaUsuario(makePasswordCrypto(usuario.getSenhaUsuario()));
                    serviceUsuario.salvar(usuario);
                    attr.addFlashAttribute("success", "Inclusão do registro realizado com sucesso!");
                }else{
                    attr.addFlashAttribute("fail", "As senhas informadas não são iguais. Por favor, tente novamente.");
                }
            }else{
                attr.addFlashAttribute("fail", "Não foi possível realizar a inclusão do registro. Verifique o preenchimento dos campos.");
            }
        }catch(Exception e){
            attr.addFlashAttribute("fail", "Não foi possível realizar a inclusão do registro.");

        }
            return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("usuarios", serviceUsuario.pesquisarTodos());
        return "/main/usuario/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("usuarios", serviceUsuario.pesquisarId(id));
        return "/main/usuario/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Usuarios usuario, RedirectAttributes attr){
        try{
            if(!usuario.getSenhaUsuario().equals("")){
                usuario.setSenhaUsuario(makePasswordCrypto(usuario.getSenhaUsuario()));
                serviceUsuario.alterar(usuario);
                attr.addFlashAttribute("success", "Alteração do registro realizada com sucesso!");
            }else{
                attr.addAttribute("fail", "Não foi possivel realizar a alteração do registro.");
            }
        }catch(Exception e){
            attr.addAttribute("fail", "Não foi possivel realizar a alteração do registro.");
        }
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        try{
            serviceUsuario.excluir(id);
            attr.addFlashAttribute("success", "Exclusão do registro realizada com sucesso!");
            return "redirect:../cadastrar";
        }catch(Exception e){
            attr.addFlashAttribute("fail", "Não foi possivel realizar a exclusão do registro!");
            return "redirect:../cadastrar";
        }
    }
      
    @ModelAttribute("cargos")
    public List<Cargos> listarTodosCargos(){
        return serviceCargo.pesquisarTodos();
    }
    
    @ModelAttribute("empresas")
    public List<Empresas> listarTodosEmpresas(){
        return serviceEmpresa.pesquisarTodos();
    }
    
    private String makePasswordCrypto(String passwd){
        return new BCryptPasswordEncoder().encode(passwd);
    }
    
}
