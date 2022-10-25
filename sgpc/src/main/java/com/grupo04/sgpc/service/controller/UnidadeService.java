/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Unidades;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface UnidadeService {
        
    public void salvar(Unidades unidade);
    public void alterar(Unidades unidade);
    public void excluir(Long id);
    public Unidades pesquisarId(Long id);
    public List<Unidades> pesquisarTodos();
}
