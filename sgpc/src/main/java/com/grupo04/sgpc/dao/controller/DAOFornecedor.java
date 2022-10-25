/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Fornecedores;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOFornecedor {
        
    public void save(Fornecedores fornecedor);
    public void update(Fornecedores fornecedor);
    public void delete(Long id);
    public Fornecedores findById(Long id);
    public List<Fornecedores> findAll();
}
