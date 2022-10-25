/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCondicaoPagamento;
import com.grupo04.sgpc.domain.controller.CondicoesPagamentos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */
@Service
public class CondicaoPagamentoSI implements CondicaoPagamentoService{
    
    @Autowired
    private DAOCondicaoPagamento dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(CondicoesPagamentos condicaoPagamento) {
        dao.save(condicaoPagamento);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(CondicoesPagamentos condicaoPagamento) {
        dao.update(condicaoPagamento);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public CondicoesPagamentos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<CondicoesPagamentos> pesquisarTodos() {
        return dao.findAll();
    }

}
