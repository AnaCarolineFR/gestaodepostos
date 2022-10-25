/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOEstoqueMovimentacao;
import com.grupo04.sgpc.domain.controller.EstoquesMovimentacoes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class EstoqueMovimentacaoSI implements EstoqueMovimentacaoService{
    
    @Autowired
    private DAOEstoqueMovimentacao dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(EstoquesMovimentacoes estoqueMovimentacao) {
        dao.save(estoqueMovimentacao);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(EstoquesMovimentacoes estoqueMovimentacao) {
        dao.update(estoqueMovimentacao);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public EstoquesMovimentacoes pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<EstoquesMovimentacoes> pesquisarTodos() {
        return dao.findAll();
    }

    
}
