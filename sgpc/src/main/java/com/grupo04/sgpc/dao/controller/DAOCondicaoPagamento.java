/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CondicoesPagamentos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOCondicaoPagamento {
        
    public void save(CondicoesPagamentos condicaopagamento);
    public void update(CondicoesPagamentos condicaopagamento);
    public void delete(Long id);
    public CondicoesPagamentos findById(Long id);
    public List<CondicoesPagamentos> findAll();
}
