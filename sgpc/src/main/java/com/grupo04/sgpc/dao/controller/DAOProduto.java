/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Produtos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOProduto {
    
    public void save(Produtos produto);
    public void update(Produtos produto);
    public void delete(Long id);
    public Produtos findById(Long id);
    public List<Produtos> findAll();
}
