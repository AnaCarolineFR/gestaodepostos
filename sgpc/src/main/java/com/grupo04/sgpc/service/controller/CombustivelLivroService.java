/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisLivros;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface CombustivelLivroService {
    
    public void salvar(CombustiveisLivros combustivelLivro);
    public void alterar(CombustiveisLivros combustivelLivro);
    public void excluir(Long id);
    public CombustiveisLivros pesquisarId(Long id);
    public List<CombustiveisLivros> pesquisarTodos();
}
