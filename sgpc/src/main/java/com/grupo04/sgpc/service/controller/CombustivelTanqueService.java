/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface CombustivelTanqueService {
    
    public void salvar(CombustiveisTanques combustivelTanque);
    public void alterar(CombustiveisTanques combustivelTanque);
    public void excluir(Long id);
    public CombustiveisTanques pesquisarId(Long id);
    public List<CombustiveisTanques> pesquisarTodos();
    
    public List<CombustiveisTanques> pesquisarDescricaoDistinta();
}
