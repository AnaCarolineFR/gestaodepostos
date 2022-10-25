/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.FornecedoresTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOFornecedorTipo {
    
    public void save(FornecedoresTipos fornecedorTipo);
    public void update(FornecedoresTipos fornecedorTipo);
    public void delete(Long id);
    public FornecedoresTipos findById(Long id);
    public List<FornecedoresTipos> findAll();
}
