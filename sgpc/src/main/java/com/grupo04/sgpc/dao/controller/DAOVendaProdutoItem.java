/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import java.util.List;


/**
 *
 * @author rafael-d
 */
public interface DAOVendaProdutoItem {
    
    public void save(VendasProdutosItens vendaProdutoItem);
    public void update (VendasProdutosItens vendaProdutoItem);
    public void delete (Long id);
    public VendasProdutosItens findById(Long id);
    public List<VendasProdutosItens> findAll();
    
}
