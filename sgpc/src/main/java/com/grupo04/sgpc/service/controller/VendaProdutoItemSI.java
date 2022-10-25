/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOVendaProdutoItem;
import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class VendaProdutoItemSI implements VendaProdutoItemService{
    
    @Autowired
    private DAOVendaProdutoItem dao;
    

    @Transactional(readOnly = false)
    @Override
    public void salvar(VendasProdutosItens vendaProdutoItem) {
        dao.save(vendaProdutoItem);
    }

    @Transactional(readOnly = false)
    @Override
    public void alterar(VendasProdutosItens vendaProdutoItem) {
        dao.update(vendaProdutoItem);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public VendasProdutosItens pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VendasProdutosItens> pesquisarTodos() {
        return dao.findAll();
    }
    
}
