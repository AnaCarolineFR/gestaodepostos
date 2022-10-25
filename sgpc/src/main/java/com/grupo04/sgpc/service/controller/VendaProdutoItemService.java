/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;


import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface VendaProdutoItemService {
    
    public void salvar(VendasProdutosItens vendaProdutoItem);
    public void alterar(VendasProdutosItens vendaProdutoItem);
    public void excluir(Long id);
    VendasProdutosItens pesquisarId(Long id);
    List<VendasProdutosItens> pesquisarTodos();
}
