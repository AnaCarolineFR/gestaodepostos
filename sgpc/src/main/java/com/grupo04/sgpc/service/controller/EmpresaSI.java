/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOEmpresa;
import com.grupo04.sgpc.domain.controller.Empresas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class EmpresaSI implements EmpresaService{
    
    @Autowired
    private DAOEmpresa dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Empresas empresa) {
        dao.save(empresa);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Empresas empresa) {
        dao.update(empresa);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Empresas pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Empresas> pesquisarTodos() {
        return dao.findAll();
    }

}
