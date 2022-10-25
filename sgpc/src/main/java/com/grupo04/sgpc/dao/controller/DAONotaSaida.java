/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.NotasSaidas;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAONotaSaida {
        
    public void save(NotasSaidas notasaida);
    public void update(NotasSaidas notasaida);
    public void delete(Long id);
    public NotasSaidas findById(Long id);
    public List<NotasSaidas> findAll();
}
