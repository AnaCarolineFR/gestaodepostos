/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutosItens;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author rafael-d
 */
public interface JPAVendaProdutoItem extends JpaRepository<VendasProdutosItens,Long>{
    
    @Query("select v from VendasProdutosItens v where v.vendaProduto.id = :id")
    Page<VendasProdutosItens> findItensByAccount(Long id, Pageable pageable);
    
    @Query("select max(v.item) from VendasProdutosItens v where v.vendaProduto.id= :idVendaProduto")
    int findMaxItem(Long idVendaProduto);
}
