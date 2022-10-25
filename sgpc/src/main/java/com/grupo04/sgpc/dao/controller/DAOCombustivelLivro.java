/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisLivros;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCombustivelLivro {
    
    public void save(CombustiveisLivros combustivellivro);
    public void update(CombustiveisLivros combustivellivro);
    public void delete(Long id);
    public CombustiveisLivros findById(Long id);
    public List<CombustiveisLivros> findAll();
}
