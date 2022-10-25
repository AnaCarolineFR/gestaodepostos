/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author rafael-d
 */
public interface JPAVendaProduto extends JpaRepository<VendasProdutos, Long>{
    
    @Query("select min(v.comanda) from VendasProdutos v where v.situacao not in ('A', 'B')")
    int searchMaxAccount();
    
    @Query("select v from VendasProdutos v where v.situacao in ('A','B')")
    List<VendasProdutos>findListByAccountOpen();
}
