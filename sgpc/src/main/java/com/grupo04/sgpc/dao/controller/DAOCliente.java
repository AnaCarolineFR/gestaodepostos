/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Clientes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCliente {
        
    public void save(Clientes cliente);
    public void update(Clientes cliente);
    public void delete(Long id);
    public Clientes findById(Long id);
    public List<Clientes> findAll();
}
