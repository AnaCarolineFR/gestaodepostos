/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOFornecedorTipo;
import com.grupo04.sgpc.domain.controller.FornecedoresTipos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class FornecedorTipoSI implements FornecedorTipoService{
    
    @Autowired
    private DAOFornecedorTipo dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(FornecedoresTipos fornecedorTipo) {
        dao.save(fornecedorTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(FornecedoresTipos fornecedorTipo) {
        dao.update(fornecedorTipo);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public FornecedoresTipos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<FornecedoresTipos> pesquisarTodos() {
        return dao.findAll();
    }

}
