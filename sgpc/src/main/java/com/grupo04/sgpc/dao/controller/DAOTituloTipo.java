/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.TitulosTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOTituloTipo {
    
    public void save(TitulosTipos tituloTipo);
    public void update(TitulosTipos tituloTipo);
    public void delete(Long id);
    public TitulosTipos findById(Long id);
    public List<TitulosTipos> findAll();
}
