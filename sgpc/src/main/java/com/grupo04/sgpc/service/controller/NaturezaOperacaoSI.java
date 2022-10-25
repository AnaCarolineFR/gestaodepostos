/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAONaturezaOperacao;
import com.grupo04.sgpc.domain.controller.NaturezasOperacoes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class NaturezaOperacaoSI implements NaturezaOperacaoService{
    
    @Autowired
    private DAONaturezaOperacao dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(NaturezasOperacoes naturezaOperacao) {
        dao.save(naturezaOperacao);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(NaturezasOperacoes naturezaOperacao) {
        dao.update(naturezaOperacao);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public NaturezasOperacoes pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<NaturezasOperacoes> pesquisarTodos() {
        return dao.findAll();
    }

}
