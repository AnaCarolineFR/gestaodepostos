/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOVendaProduto;
import com.grupo04.sgpc.dao.controller.JPAVendaProdutoItem;
import com.grupo04.sgpc.dao.controller.VendaProdutoDI;
import com.grupo04.sgpc.dao.controller.VendaProdutoItemDI;
import com.grupo04.sgpc.datatables.Datatables;
import com.grupo04.sgpc.datatables.DatatablesColunas;
import com.grupo04.sgpc.domain.controller.VendasProdutos;
import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class VendaProdutoSI implements VendaProdutoService{

    @Autowired
    private DAOVendaProduto dao;
    
    @Autowired
    private VendaProdutoDI daoVendaProduto;  
    
    @Autowired 
    private VendaProdutoItemDI daoVendaProdutoItemDI;

    @Autowired
    private JPAVendaProdutoItem jpaVendaProdutoItem;
    
    @Autowired
    private Datatables datatables;
    
    
    @Transactional(readOnly = false)
    @Override
    public void salvar(VendasProdutos vendaProduto) {
        dao.save(vendaProduto);
    }

    @Transactional(readOnly = false)
    @Override
    public void alterar(VendasProdutos vendaProduto) {
        dao.update(vendaProduto);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public VendasProdutos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VendasProdutos> pesquisarTodos() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public VendasProdutos pesquisarComanda(int comanda) {
        VendasProdutos vp = new VendasProdutos();
        List<VendasProdutos> lista = daoVendaProduto.findByAccount(comanda);
            if(lista.size() > 0){
              vp.setId(lista.get(0).getId());
              vp.setComanda(lista.get(0).getComanda());
              vp.setSituacao(lista.get(0).getSituacao());
              vp.setDtAbertura(lista.get(0).getDtAbertura());
              vp.setDtAlteracao(lista.get(0).getDtAlteracao());
              vp.setDtEncerramento(lista.get(0).getDtEncerramento());
              vp.setQtdTotal(lista.get(0).getQtdTotal());
              vp.setVlrTotal(lista.get(0).getVlrTotal());
              ArrayList<VendasProdutosItens> arrayList = pesquisaItemComanda(vp);
              if(arrayList.size() > 0){
                  int qtdTotal = 0;
                  double vlrTotal = 0;
                  for(int i = 0; i < arrayList.size(); i++){
                      qtdTotal += arrayList.get(i).getQuantidade();
                      vlrTotal += arrayList.get(i).getVlrTotal();
                  }
                  vp.setQtdTotal(qtdTotal);
                  vp.setVlrTotal(vlrTotal);
              }
              return vp;
            }
        return vp;
    }

    @Transactional(readOnly = true)
    private ArrayList<VendasProdutosItens> pesquisaItemComanda(VendasProdutos vp){
        return daoVendaProdutoItemDI.findByIdAccount(vp.getId());
    }
    
   @Transactional(readOnly = true)
   public Map<String, Object> carregaItemComanda(HttpServletRequest request, Long id){
       datatables.setRequest(request);
       datatables.setColunas(DatatablesColunas.ITENSCOMANDA);
       Page<?> page = jpaVendaProdutoItem.findItensByAccount(id,datatables.getPageable());
       return datatables.getResponse(page);
   }
   
    
}
