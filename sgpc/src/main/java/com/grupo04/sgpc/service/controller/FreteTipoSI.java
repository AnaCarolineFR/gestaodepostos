/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOFreteTipo;
import com.grupo04.sgpc.domain.controller.FretesTipos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class FreteTipoSI implements FreteTipoService{
    
    @Autowired
    private DAOFreteTipo dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(FretesTipos freteTipo) {
        dao.save(freteTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(FretesTipos freteTipo) {
        dao.update(freteTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public FretesTipos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<FretesTipos> pesquisarTodos() {
        return dao.findAll();
    }

    
}
