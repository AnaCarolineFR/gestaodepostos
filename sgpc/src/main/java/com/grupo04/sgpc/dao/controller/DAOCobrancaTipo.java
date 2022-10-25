/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CobrancasTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCobrancaTipo {
    
    public void save(CobrancasTipos cobrancatipo);
    public void update(CobrancasTipos cobrancatipo);
    public void delete(Long id);
    public CobrancasTipos findById(Long id);
    public List<CobrancasTipos> findAll();
}
