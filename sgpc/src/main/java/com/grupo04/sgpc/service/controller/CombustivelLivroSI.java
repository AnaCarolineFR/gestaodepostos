/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOCombustivelLivro;
import com.grupo04.sgpc.domain.controller.CombustiveisLivros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class CombustivelLivroSI implements CombustivelLivroService{
    
    @Autowired
    private DAOCombustivelLivro dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(CombustiveisLivros combustivelLivro) {
        dao.save(combustivelLivro);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(CombustiveisLivros combustivelLivro) {
        dao.update(combustivelLivro);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public CombustiveisLivros pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<CombustiveisLivros> pesquisarTodos() {
        return dao.findAll();
    }

}
