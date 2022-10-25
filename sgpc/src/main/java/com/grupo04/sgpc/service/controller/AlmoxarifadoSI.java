/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOAlmoxarifado;
import com.grupo04.sgpc.domain.controller.Almoxarifados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class AlmoxarifadoSI implements AlmoxarifadoService{
    
    @Autowired
    private DAOAlmoxarifado dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Almoxarifados almoxarifado) {
        dao.save(almoxarifado);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Almoxarifados almoxarifado) {
        dao.update(almoxarifado);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Almoxarifados pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Almoxarifados> pesquisarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean Almoxarifados(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
