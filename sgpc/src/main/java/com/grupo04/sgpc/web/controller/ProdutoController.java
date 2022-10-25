/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.dao.controller.JPAProduto;
import com.grupo04.sgpc.domain.controller.Almoxarifados;
import com.grupo04.sgpc.domain.controller.Produtos;
import com.grupo04.sgpc.domain.controller.Unidades;
import com.grupo04.sgpc.service.controller.AlmoxarifadoService;
import com.grupo04.sgpc.service.controller.ProdutoSI;
import com.grupo04.sgpc.service.controller.ProdutoService;
import com.grupo04.sgpc.service.controller.UnidadeService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private UnidadeService serviceUnidade;
    
    @Autowired
    private ProdutoService serviceProduto;
    
    @Autowired
    private AlmoxarifadoService serviceAlmoxarifado;
    
    @Autowired
    private JPAProduto jpaProduto;
    
    @GetMapping("cadastrar")
    public String cadastrar(Produtos produto){
        return "/main/produto/cadastro";
    }
    
    @PostMapping("salvar")
    public String salvar(Produtos produto, RedirectAttributes attr){
        try{
            if(!produto.getDescricao().isEmpty()){
                serviceProduto.salvar(produto);
                attr.addFlashAttribute("success", "Inclusão do registro realizada com sucesso.");
            }else{
                attr.addFlashAttribute("fail", "Não foi possivel realizar a inclusão do registro. Verifique o preenchimento dos campos.");
            }
        }catch(Exception e){
            attr.addFlashAttribute("fail", "Não foi possivel realizar a inclusão do registro.");
        }
        return "redirect:cadastrar";
    }
    
    @GetMapping("listar")
    public String listar(ModelMap model){
        model.addAttribute("produtos", serviceProduto.pesquisarTodos());
        return "main/produto/cadastro";
    }
    
    @GetMapping("cadastrar/tabelas")
    public ResponseEntity<?> datatables(HttpServletRequest request){
        Map<String, Object> data = new ProdutoSI().execute(jpaProduto, request);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/editar/{id}")
    public String carregarItem(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("produtos", serviceProduto.pesquisarId(id));
        return "/main/produto/cadastro";
    }
    
    @PostMapping("/editar")
    public String editar(Produtos produto){
        serviceProduto.alterar(produto);
        return "redirect:cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        serviceProduto.excluir(id);
        return "redirect:listar";
    }
    
    @ModelAttribute("unidades")
    public List<Unidades> listarTodasUnidades(){
        return serviceUnidade.pesquisarTodos();
    }
    
    @ModelAttribute("almoxarifados")
    public List<Almoxarifados> listarTodosAlmoxarifados(){
        return serviceAlmoxarifado.pesquisarTodos();
    }
}
