/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOTituloReceber;
import com.grupo04.sgpc.domain.controller.TitulosReceber;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class TituloReceberSI implements TituloReceberService{
    
    @Autowired
    private DAOTituloReceber dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(TitulosReceber tituloReceber) {
        dao.save(tituloReceber);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(TitulosReceber tituloReceber) {
        dao.update(tituloReceber);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public TitulosReceber pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<TitulosReceber> pesquisarTodos() {
        return dao.findAll();
    }

}
