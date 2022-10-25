/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.CondicoesPagamentos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface CondicaoPagamentoService {
    
    public void salvar(CondicoesPagamentos condicaoPagamento);
    public void alterar(CondicoesPagamentos condicaoPagamento);
    public void excluir(Long id);
    public CondicoesPagamentos pesquisarId(Long id);
    public List<CondicoesPagamentos> pesquisarTodos();
}
