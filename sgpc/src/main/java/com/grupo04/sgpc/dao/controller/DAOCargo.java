/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Cargos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCargo {
    
    public void save(Cargos cargo);
    public void update(Cargos cargo);
    public void delete(Long id);
    public Cargos findById(Long id);
    public List<Cargos> findAll();
}
