/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOFornecedor;
import com.grupo04.sgpc.domain.controller.Fornecedores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class FornecedorSI implements FornecedorService{
    
    @Autowired
    private DAOFornecedor dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Fornecedores fornecedor) {
        dao.save(fornecedor);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Fornecedores fornecedor) {
        dao.update(fornecedor);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Fornecedores pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Fornecedores> pesquisarTodos() {
        return dao.findAll();
    }

    
}
