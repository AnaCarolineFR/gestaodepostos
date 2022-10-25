/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Usuarios;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOUsuario {
    public void save(Usuarios usuario);
    public void update(Usuarios usuario);
    public void delete(Long id);
    public Usuarios findById(Long id);
    public List<Usuarios> findAll();

    public List<Usuarios> findByNickname(String apelidoUsuario);
    
}
