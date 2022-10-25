/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Estoques;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface EstoqueService {
    
    public void salvar(Estoques estoque);
    public void alterar(Estoques estoque);
    public void excluir(Long id);
    public Estoques pesquisarId(Long id);
    public List<Estoques> pesquisarTodos();
}
