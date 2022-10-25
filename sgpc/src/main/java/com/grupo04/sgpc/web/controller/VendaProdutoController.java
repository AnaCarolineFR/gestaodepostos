/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.controller;

import com.grupo04.sgpc.dao.controller.JPAProduto;
import com.grupo04.sgpc.dao.controller.JPAVendaProduto;
import com.grupo04.sgpc.dao.controller.JPAVendaProdutoItem;
import com.grupo04.sgpc.domain.controller.Produtos;
import com.grupo04.sgpc.domain.controller.Usuarios;
import com.grupo04.sgpc.domain.controller.VendasProdutos;
import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import com.grupo04.sgpc.service.controller.ProdutoSI;
import com.grupo04.sgpc.service.controller.VendaProdutoItemService;
import com.grupo04.sgpc.service.controller.VendaProdutoSI;
import com.grupo04.sgpc.service.controller.VendaProdutoService;
import java.util.Date;
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
@RequestMapping("/lojas")
public class VendaProdutoController {
   
    @Autowired
    private JPAProduto jpaProduto;
    
    @Autowired
    private JPAVendaProduto jpaVendaProduto;
    
    @Autowired 
    private JPAVendaProdutoItem jpaVendaProdutoItem;
    
    @Autowired
    private VendaProdutoService serviceVendaProduto;
    
    @Autowired
    private VendaProdutoItemService serviceVendaProdutoItem;
    
    @Autowired
    private ProdutoSI siProduto;
        
    @Autowired
    private VendaProdutoSI siVendaProduto;
    
    /***********************************************************************
    * Método retorna as comandas em aberto, e carrega na página principal
    * da loja de convêniencia, a jpaVendaProduto tem um filtro para retornar
    * somente comandas com situação A= Aberta e B=Bloqueada;
    * Não sei ainda se vamos utilizar essa situacao B, mas resolvi mantê-la.
    ***********************************************************************/
    @GetMapping("/")
    public String pesquisaComandaAberta(ModelMap model){
        model.addAttribute("vendasProdutos", jpaVendaProduto.findListByAccountOpen());
        return "main/lojas";
    }
    
    @GetMapping("vendas")
    public String venda(Produtos produto, VendasProdutos vendaProduto, VendasProdutosItens vendaProdutoItem){
        return "main/loja/venda";
    }
    
    @GetMapping("vendas/listarProdutos")
    public String listarProduto(){
        return "main/loja/listarProduto";
    }
    
    @GetMapping("vendas/server/{id}")
    public ResponseEntity<?> datatables(@PathVariable("id") Long id, HttpServletRequest request){
        try{
            return ResponseEntity.ok(siVendaProduto.carregaItemComanda(request, id));
        }catch(Exception e){
            return ResponseEntity.ok(e);
        }
    }
    
    @GetMapping("vendas/listarProdutos/server")
    public ResponseEntity<?> datatables(HttpServletRequest request){
        Map<String, Object> data = new ProdutoSI().execute(jpaProduto, request);
        return ResponseEntity.ok(data);
    }
    
    /*********************************************************************
    * Método criado para localizar um número de comanda disponível para 
    * utilização, isso foi criado para ficar mais com cara de comanda do
    * que de pedido, pois a numeracao da comanda seria crescente, acredito
    * que ficaria um pouco deselegante.
    **********************************************************************/
    private boolean localizaComandaDisponivel(int comanda){
        List<VendasProdutos> lista = jpaVendaProduto.findListByAccountOpen();
        for(int i = 0; i < lista.size(); i++ ){
            if(lista.get(i).getComanda() == comanda){
                return false;
            }
        }
        return true;
    }
    
   
    @PostMapping("vendas/addComanda")
    public ResponseEntity<VendasProdutos> salvarComanda(VendasProdutos vendaProduto){
        try{
            Date dataAtual = new Date();
            int comanda = jpaVendaProduto.searchMaxAccount();
            while(!localizaComandaDisponivel(comanda)){
                comanda++;
            }
            vendaProduto.setComanda(comanda);
            vendaProduto.setDtAbertura(dataAtual);
            vendaProduto.setDtAlteracao(dataAtual);
            serviceVendaProduto.salvar(vendaProduto);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    
//    public String addComanda(VendasProdutos vendaProduto,  Produtos produto, VendasProdutosItens vendaProdutoItem, RedirectAttributes attr){
//        try{
//            Date dataAtual = new Date();
//            VendasProdutos vp = new VendasProdutos();
//            int comanda = jpaVendaProduto.searchMaxAccount();
//            List<VendasProdutos> lista = jpaVendaProduto.findListByAccountOpen();
//            while(!localizaComandaDisponivel(comanda, lista)){
//                comanda++;
//            }
//            vp.setComanda(comanda);
//            vp.setSituacao("A");
//            vp.setDtAbertura(dataAtual);
//            vp.setDtAlteracao(dataAtual);
//            serviceVendaProduto.salvar(vp);
//            attr.addFlashAttribute("success", "Comanda aberta com sucesso!");
//            return "redirect:/lojas/vendas";
//        }catch(Exception e){
//            attr.addFlashAttribute("fail", "Ocorreu um problema ao realizar a operação de inclusão! Por favor tente novamente mais tarde.");
//            return "redirect:/lojas/vendas";
//        }
//    }
    
    @PostMapping("vendas/addProduto")
    public String addProduto(VendasProdutos vendaProduto, Produtos produto, VendasProdutosItens vendaProdutoItem, RedirectAttributes attr ){
        try{
            Date dataAtual = new Date();
                Usuarios u = new Usuarios();
                u.setId(Long.parseLong("1"));
                VendasProdutosItens vpi = new VendasProdutosItens();
                int item =+ jpaVendaProdutoItem.findMaxItem(vendaProduto.getId());
                Double vlrTotalItem = produto.getPrecoVenda() * vendaProdutoItem.getQuantidade();
                vpi.setItem(item);
                vpi.setQuantidade(vendaProdutoItem.getQuantidade());
                vpi.setVlrUnitario(produto.getPrecoVenda());
                vpi.setVlrTotal(vlrTotalItem);
                vpi.setProduto(produto);
                vpi.setVendaProduto(vendaProduto);
                vpi.setUsuario(u);
                vpi.setDtInclusao(dataAtual);
                vpi.setDtAlteracao(dataAtual);
                serviceVendaProdutoItem.salvar(vpi);
                attr.addFlashAttribute("success", "Produto adicionado à comanda com sucesso!");
                return "redirect:/lojas/vendas";
        }catch(Exception e){
            attr.addFlashAttribute("fail", "Ocorreu um problema ao realizar a operação de inclusão! Por favor tente novamente mais tarde.");
            return "redirect:/lojas/vendas";
        }
    }
    

    
    /***********************************************************************
    * Método pesquisa pela comanda e carrega lista de itens da comanda, 
    * nesse caso é necessário declarar o @ModelAttribute do objeto 
    * Produtos para carregar o model completo.
    * Não alterar a assinatura do método, se não for realmente necessário.
    ************************************************************************/
    @GetMapping("vendas/pesquisaComandas/{comanda}")
    public String carregaComanda(@PathVariable("comanda") int comanda, @ModelAttribute("produtos") Produtos produto,@ModelAttribute("vendasProdutosItens") VendasProdutosItens vendaProdutoItem, ModelMap model, HttpServletRequest request, RedirectAttributes attr){
        //VendasProdutos vp = new VendasProdutos();
        try{
            model.addAttribute("vendasProdutos", serviceVendaProduto.pesquisarComanda(comanda));
            attr.addFlashAttribute("success", "Comanda localizada com sucesso!");
            return "main/loja/venda";
        }catch(Exception e){
            attr.addFlashAttribute("fail", "Não foi possivel localizar a comanda informada, tente novamente.");
            return "main/loja/venda";
        }
    }
    
    /***********************************************************************
    * Método recebe uma pesquisa AJAX informando na url o gtin do produto,
    * é necessário avaliar se essa é a melhor maneira de realizar essa rotina
    * acredito que um POST seja mais elegante.
    ***********************************************************************/
    @GetMapping("vendas/pesquisaProdutos/{gtin}")
    public ResponseEntity<?> carregaProduto(@PathVariable("gtin")Long gtin, Produtos produto, HttpServletRequest request){
        return ResponseEntity.ok(siProduto.pesquisarProduto(gtin));
    }
    
    /***********************************************************************
    * Verificar se dá pra fazer esse método como padrão para o retorno das
    * mensagens.
    ************************************************************************/
    private String stringMensagem(Object obj, String tipo, String mensagem, RedirectAttributes attr){
        String msg = tipo + "," +mensagem;
        attr.addFlashAttribute(msg, obj);
        return "main/loja/venda";
    }
                
                
}
