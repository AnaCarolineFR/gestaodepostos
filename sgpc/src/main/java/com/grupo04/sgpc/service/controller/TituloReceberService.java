/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.TitulosReceber;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface TituloReceberService {
    
    public void salvar(TitulosReceber tituloReceber);
    public void alterar(TitulosReceber tituloReceber);
    public void excluir(Long id);
    public TitulosReceber pesquisarId(Long id);
    public List<TitulosReceber> pesquisarTodos();
}
