/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.CobrancasTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface CobrancaTipoService {
    
    public void salvar(CobrancasTipos cobrancaTipo);
    public void alterar(CobrancasTipos cobrancaTipo);
    public void excluir(Long id);
    public CobrancasTipos pesquisarId(Long id);
    public List<CobrancasTipos> pesquisarTodos();
}
