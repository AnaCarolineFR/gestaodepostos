/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOVendaProduto {
    
    public void save(VendasProdutos vendaProduto);
    public void update(VendasProdutos vendaProduto);
    public void delete(Long id);
    public VendasProdutos findById(Long id);
    List <VendasProdutos> findAll();
    

}
