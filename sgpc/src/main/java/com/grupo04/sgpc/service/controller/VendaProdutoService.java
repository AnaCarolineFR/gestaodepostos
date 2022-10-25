/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface VendaProdutoService {
    
    public void salvar(VendasProdutos vendaProduto);
    public void alterar(VendasProdutos vendaProduto);
    public void excluir(Long id);
    VendasProdutos pesquisarId(Long id);
    List<VendasProdutos> pesquisarTodos();

    public VendasProdutos pesquisarComanda(int comanda);

    
}
