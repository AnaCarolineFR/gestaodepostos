/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.VendasCombustiveis;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface VendaCombustivelService {
    public void salvar(VendasCombustiveis vendaCombustivel);
    public void alterar(VendasCombustiveis vendaCombustivel);
    public void excluir(Long id);
    VendasCombustiveis pesquisarId(Long id);
    List<VendasCombustiveis> pesquisarTodos();
}
