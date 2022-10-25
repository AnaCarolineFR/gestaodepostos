/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Unidades;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOUnidade {
    public void save(Unidades usuario);
    public void update(Unidades usuario);
    public void delete(Long id);
    public Unidades findById(Long id);
    public List<Unidades> findAll();
}
