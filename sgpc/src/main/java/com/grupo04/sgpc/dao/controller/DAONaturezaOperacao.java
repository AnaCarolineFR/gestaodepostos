/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.NaturezasOperacoes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAONaturezaOperacao {
    
    public void save(NaturezasOperacoes naturezaoperacao);
    public void update(NaturezasOperacoes naturezaoperacao);
    public void delete(Long id);
    public NaturezasOperacoes findById(Long id);
    public List<NaturezasOperacoes> findAll();
}
