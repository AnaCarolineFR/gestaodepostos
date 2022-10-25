/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOTituloPagar;
import com.grupo04.sgpc.domain.controller.TitulosPagar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class TituloPagarSI implements TituloPagarService{
    
    @Autowired
    private DAOTituloPagar dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(TitulosPagar tituloPagar) {
        dao.save(tituloPagar);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(TitulosPagar tituloPagar) {
        dao.update(tituloPagar);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public TitulosPagar pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<TitulosPagar> pesquisarTodos() {
        return dao.findAll();
    }

}
