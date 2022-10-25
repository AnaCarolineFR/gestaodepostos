/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.EstoquesMovimentacoes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface EstoqueMovimentacaoService {
    
    public void salvar(EstoquesMovimentacoes estoqueMovimentacao);
    public void alterar(EstoquesMovimentacoes estoqueMovimentacao);
    public void excluir(Long id);
    public EstoquesMovimentacoes pesquisarId(Long id);
    public List<EstoquesMovimentacoes> pesquisarTodos();
}
