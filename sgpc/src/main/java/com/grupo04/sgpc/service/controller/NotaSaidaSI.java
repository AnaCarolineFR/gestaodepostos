/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAONotaSaida;
import com.grupo04.sgpc.domain.controller.NotasSaidas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class NotaSaidaSI implements NotaSaidaService{
    
    @Autowired
    private DAONotaSaida dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(NotasSaidas notaSaida) {
        dao.save(notaSaida);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(NotasSaidas notaSaida) {
        dao.update(notaSaida);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public NotasSaidas pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<NotasSaidas> pesquisarTodos() {
        return dao.findAll();
    }

}
