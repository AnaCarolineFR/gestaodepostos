/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.TitulosReceber;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOTituloReceber {
    public void save(TitulosReceber tituloreceber);
    public void update(TitulosReceber tituloreceber);
    public void delete(Long id);
    public TitulosReceber findById(Long id);
    public List<TitulosReceber> findAll();
}
