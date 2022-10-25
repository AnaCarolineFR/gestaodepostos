/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCargo;
import com.grupo04.sgpc.domain.controller.Cargos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class CargoSI implements CargoService{

    @Autowired
    private DAOCargo dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Cargos cargo) {
        dao.save(cargo);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Cargos cargo) {
        dao.update(cargo);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Cargos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Cargos> pesquisarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean usuarioCargos(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
