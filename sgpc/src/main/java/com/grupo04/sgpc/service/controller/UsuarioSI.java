/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOUsuario;
import com.grupo04.sgpc.domain.controller.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class UsuarioSI implements UsuarioService{
    
    @Autowired
    private DAOUsuario dao;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Usuarios usuario) {
        dao.save(usuario);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Usuarios usuario) {
        dao.update(usuario);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Usuarios pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Usuarios> pesquisarTodos() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuarios> pesquisaPorApelido(String apelidoUsuario) {
        return dao.findByNickname(apelidoUsuario);
    }



}
