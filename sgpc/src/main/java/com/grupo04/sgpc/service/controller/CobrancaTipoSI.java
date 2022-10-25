/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCobrancaTipo;
import com.grupo04.sgpc.domain.controller.CobrancasTipos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class CobrancaTipoSI implements CobrancaTipoService{
    
    @Autowired
    private DAOCobrancaTipo dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(CobrancasTipos cobrancaTipo) {
        dao.save(cobrancaTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(CobrancasTipos cobrancaTipo) {
        dao.update(cobrancaTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public CobrancasTipos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<CobrancasTipos> pesquisarTodos() {
        return dao.findAll();
    }

}
