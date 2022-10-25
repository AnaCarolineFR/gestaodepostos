/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Estoques;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOEstoque {
    
    public void save(Estoques estoque);
    public void update(Estoques estoque);
    public void delete(Long id);
    public Estoques findById(Long id);
    public List<Estoques> findAll();
}
