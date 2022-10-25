/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Produtos;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author rafael-d
 */
@Repository
public class ProdutoDI extends DAOAbstrata<Produtos, Long> implements DAOProduto{
    
    public List<Produtos> pesquisaPorGtin(Long gtin){
        return createQuery("select p from Produtos p where p.gtin = ?1", gtin);
    }
    
}

