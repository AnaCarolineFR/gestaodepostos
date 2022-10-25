/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.EstoquesMovimentacoes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface DAOEstoqueMovimentacao {
        
    public void save(EstoquesMovimentacoes estoquemovimentacao);
    public void update(EstoquesMovimentacoes estoquemovimentacao);
    public void delete(Long id);
    public EstoquesMovimentacoes findById(Long id);
    public List<EstoquesMovimentacoes> findAll();
}
