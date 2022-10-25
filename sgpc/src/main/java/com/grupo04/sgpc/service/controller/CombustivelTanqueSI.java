/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCombustivelTanque;
import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class CombustivelTanqueSI implements CombustivelTanqueService{
    
    @Autowired
    private DAOCombustivelTanque dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(CombustiveisTanques combustivelTanque) {
        dao.save(combustivelTanque);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(CombustiveisTanques combustivelTanque) {
        dao.update(combustivelTanque);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public CombustiveisTanques pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<CombustiveisTanques> pesquisarTodos() {
        return dao.findAll();
    }

    @Override
    public List<CombustiveisTanques> pesquisarDescricaoDistinta() {
       return dao.findDistinctDescription();
    }

}
