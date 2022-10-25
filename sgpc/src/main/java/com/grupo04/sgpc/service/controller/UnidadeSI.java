/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOUnidade;
import com.grupo04.sgpc.domain.controller.Unidades;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class UnidadeSI implements UnidadeService{
    
    @Autowired
    private DAOUnidade dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Unidades unidade) {
        dao.save(unidade);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Unidades unidade) {
        dao.update(unidade);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Unidades pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Unidades> pesquisarTodos() {
        return dao.findAll();
    }

}
