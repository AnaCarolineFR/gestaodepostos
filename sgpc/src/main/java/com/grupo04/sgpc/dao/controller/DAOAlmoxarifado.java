/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Almoxarifados;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOAlmoxarifado {
    
    public void save(Almoxarifados almoxarifado);
    public void update(Almoxarifados almoxarifado);
    public void delete(Long id);
    Almoxarifados findById(Long id);
    List<Almoxarifados> findAll();
}
