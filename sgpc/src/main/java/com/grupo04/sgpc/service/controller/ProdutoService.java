/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Produtos;
import java.util.List;

/**
 *
 * @author rafael-d
 */

public interface ProdutoService{
        
    public void salvar(Produtos produto);
    public void alterar(Produtos produto);
    public void excluir(Long id);
    public Produtos pesquisarId(Long id);
    public List<Produtos> pesquisarTodos();

}
