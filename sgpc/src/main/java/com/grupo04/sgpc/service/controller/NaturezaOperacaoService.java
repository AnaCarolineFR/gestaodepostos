/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.NaturezasOperacoes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface NaturezaOperacaoService {
        
    public void salvar(NaturezasOperacoes naturezaOperacao);
    public void alterar(NaturezasOperacoes naturezaOperacao);
    public void excluir(Long id);
    public NaturezasOperacoes pesquisarId(Long id);
    public List<NaturezasOperacoes> pesquisarTodos();
}
