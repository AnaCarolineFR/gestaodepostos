/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author rafael-d
 */

@Repository
public class VendaProdutoItemDI extends DAOAbstrata<VendasProdutosItens, Long> implements DAOVendaProdutoItem{
    
    public ArrayList<VendasProdutosItens> findByIdAccount(long idVendaProduto) {;
        ArrayList<VendasProdutosItens> arrayList = new ArrayList();
        List<VendasProdutosItens> list;
        list  = createQuery("select v from VendasProdutosItens v where v.vendaProduto.id=?1", idVendaProduto);
        if(list.size() > -1){
            for(int i =0 ; i < list.size(); i++){
                VendasProdutosItens vpi = new VendasProdutosItens();
                vpi.setId(list.get(i).getId());
                vpi.setItem(list.get(i).getItem());
                vpi.setQuantidade(list.get(i).getQuantidade());
                vpi.setVlrUnitario(list.get(i).getVlrUnitario());
                vpi.setVlrTotal(list.get(i).getVlrTotal());
                vpi.setDtInclusao(list.get(i).getDtInclusao());
                vpi.setDtAlteracao(list.get(i).getDtAlteracao());
                vpi.setVendaProduto(list.get(i).getVendaProduto());
                vpi.setUsuario(list.get(i).getUsuario());
                vpi.setProduto(list.get(i).getProduto());
                arrayList.add(vpi);
            }
            return arrayList;
        }
        return null;
    } 
    
}
