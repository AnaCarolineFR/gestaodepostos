/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.VendasProdutos;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafael-d
 */

@Repository
public class VendaProdutoDI extends DAOAbstrata<VendasProdutos, Long> implements DAOVendaProduto{
    
    public List<VendasProdutos> findByAccount(int comanda) {
        return createQuery("select v from VendasProdutos v where v.comanda = ?1 and situacao = 'A'", comanda);
    }  

}
