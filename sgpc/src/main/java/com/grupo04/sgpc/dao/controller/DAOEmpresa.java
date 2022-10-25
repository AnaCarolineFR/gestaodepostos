/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Empresas;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOEmpresa {
    
    public void save(Empresas empresa);
    public void update(Empresas empresa);
    public void delete(Long id);
    public Empresas findById(Long id);
    public List<Empresas> findAll();
    
}
