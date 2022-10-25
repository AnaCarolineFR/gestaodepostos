/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOVendaCombustivel;
import com.grupo04.sgpc.domain.controller.VendasCombustiveis;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class VendaCombustivelSI implements VendaCombustivelService{

    @Autowired
    private DAOVendaCombustivel dao;
    
    @Transactional(readOnly = false)
    @Override
    public void salvar(VendasCombustiveis vendaCombustivel) {
        dao.save(vendaCombustivel);
    }

    @Transactional(readOnly = false)
    @Override
    public void alterar(VendasCombustiveis vendaCombustivel) {
        dao.update(vendaCombustivel);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public VendasCombustiveis pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<VendasCombustiveis> pesquisarTodos() {
        return dao.findAll();
    }
    
}
