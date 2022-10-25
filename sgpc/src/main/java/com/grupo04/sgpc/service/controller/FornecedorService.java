/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Fornecedores;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface FornecedorService {
    
    public void salvar(Fornecedores fornecedor);
    public void alterar(Fornecedores fornecedor);
    public void excluir(Long id);
    public Fornecedores pesquisarId(Long id);
    public List<Fornecedores> pesquisarTodos();
}
