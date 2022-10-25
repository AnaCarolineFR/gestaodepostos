/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCombustivelTanque {
        
    public void save(CombustiveisTanques combustiveltanque);
    public void update(CombustiveisTanques combustiveltanque);
    public void delete(Long id);
    public CombustiveisTanques findById(Long id);
    public List<CombustiveisTanques>findAll();
    
    public List<CombustiveisTanques> findDistinctDescription();
}
