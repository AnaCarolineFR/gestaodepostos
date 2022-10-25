/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.dao.controller.JPACombustivelTanque;
import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import com.grupo04.sgpc.domain.controller.Usuarios;
import com.grupo04.sgpc.domain.controller.VendasCombustiveis;
import com.grupo04.sgpc.service.controller.CombustivelTanqueService;
import com.grupo04.sgpc.service.controller.UsuarioService;
import com.grupo04.sgpc.service.controller.VendaCombustivelService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rafael-d
 */

@Controller
@RequestMapping("/pistas")
public class VendaCombustivelController {
    
    @Autowired
    private UsuarioService serviceUsuario;
    
    @Autowired
    private CombustivelTanqueService serviceCombustivelTanque; 
    
    @Autowired
    private VendaCombustivelService serviceVendaCombustivel;
    
    @Autowired
    private JPACombustivelTanque jpaCombustivelTanque;
    
    @GetMapping("/")
    public String pesquisaCombustivelAberto(ModelMap model){
        return "main/pistas";
    }
    
    @GetMapping("vendas")
    public String venda(VendasCombustiveis vendaCombustivel, Usuarios usuario, CombustiveisTanques combustivelTanque){
        return "main/pista/venda";
    }
    
    
    @PostMapping("/vendas/abastecimento")
    public String abastecer(VendasCombustiveis vendaCombustivel, RedirectAttributes attr){
        serviceVendaCombustivel.salvar(vendaCombustivel);
        attr.addFlashAttribute("success", "Venda de combustível realizada com sucesso!");
        return "/pistas/vendas";
    }
    
    
    
    @PostMapping("/vendas/existeCombustivel")
    public ResponseEntity<CombustiveisTanques> pesquisaCombustivelTanque(CombustiveisTanques combustivelTanque, HttpServletRequest request){
        
        CombustiveisTanques c = jpaCombustivelTanque.searchFuel("BOMBA 01)", Long.parseLong("5"));
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/vendas/existeUsuario/{id}")
    public String pesquisaUsuario(@PathVariable("id") Long id, 
            @ModelAttribute("usuarios")Usuarios usuario, 
            @ModelAttribute("vendasCombustiveis")VendasCombustiveis vendaCombustivel,
            @ModelAttribute("combustiveisTanques")CombustiveisTanques combustivelTanque,
            ModelMap model, HttpServletRequest request ,RedirectAttributes attr){
        try{
            Usuarios usr = new Usuarios();
            usr = serviceUsuario.pesquisarId(id);
            if(!usr.getApelidoUsuario().isEmpty()){
                model.addAttribute("usuarios", usr);
            }else{
                model.addAttribute("usuarios", null);
            }
           return "main/pista/venda";
        }catch(Exception e){
            return "main/pista/venda";
        }
    }
    
    @ModelAttribute("tipoCombustiveisTanques")
    public List<CombustiveisTanques> listaTodosTiposCombustiveisTanques(){
        return serviceCombustivelTanque.pesquisarTodos();
    }
    
    @ModelAttribute("combustiveisTanques")
    public List<CombustiveisTanques> listaTodosTanquesCombustiveis(){
        return jpaCombustivelTanque.searchDescriptionDistinct();
    }
    
}
