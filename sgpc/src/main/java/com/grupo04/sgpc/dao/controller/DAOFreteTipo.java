/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.FretesTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOFreteTipo {
    
    public void save(FretesTipos freteTipo);
    public void update(FretesTipos freteTipo);
    public void delete(Long id);
    public FretesTipos findById(Long id);
    public List<FretesTipos> findAll();
}
