/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.TitulosPagar;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOTituloPagar {
    public void save(TitulosPagar titulopagar);
    public void update(TitulosPagar titulopagar);
    public void delete(Long id);
    public TitulosPagar findById(Long id);
    public List<TitulosPagar> findAll();
}
