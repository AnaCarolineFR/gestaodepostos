/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAONotaEntrada;
import com.grupo04.sgpc.domain.controller.NotasEntradas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class NotaEntradaSI implements NotaEntradaService{
    
    @Autowired
    private DAONotaEntrada dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(NotasEntradas notaEntrada) {
        dao.save(notaEntrada);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(NotasEntradas notaEntrada) {
        dao.update(notaEntrada);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public NotasEntradas pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<NotasEntradas> pesquisarTodos() {
        return dao.findAll();
    }

    
}
