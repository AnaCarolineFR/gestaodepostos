/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOEstoque;
import com.grupo04.sgpc.domain.controller.Estoques;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class EstoqueSI implements EstoqueService{
    
    @Autowired
    private DAOEstoque dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Estoques estoque) {
        dao.save(estoque);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Estoques estoque) {
        dao.update(estoque);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Estoques pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Estoques> pesquisarTodos() {
        return dao.findAll();
    }

}
