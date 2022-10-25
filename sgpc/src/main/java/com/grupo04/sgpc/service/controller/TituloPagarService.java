/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.TitulosPagar;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface TituloPagarService {
    
    public void salvar(TitulosPagar tituloPagar);
    public void alterar(TitulosPagar tituloPagar);
    public void excluir(Long id);
    public TitulosPagar pesquisarId(Long id);
    public List<TitulosPagar> pesquisarTodos();
}
