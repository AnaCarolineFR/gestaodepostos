/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCliente;
import com.grupo04.sgpc.domain.controller.Clientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */
@Service
public class ClienteSI implements ClienteService{
    
    @Autowired
    private DAOCliente dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Clientes cliente) {
        dao.save(cliente);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Clientes cliente) {
        dao.update(cliente);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Clientes pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Clientes> pesquisarTodos() {
        return dao.findAll();
    }

    
}
