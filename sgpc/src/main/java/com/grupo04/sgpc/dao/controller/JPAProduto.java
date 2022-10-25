/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author rafael-d
 */
public interface JPAProduto  extends JpaRepository<Produtos, Long>{ 
    
     @Query("select p from Produtos p where p.gtin = :gtin")
     Page<Produtos> findByGtin(Long gtin, Pageable pageable);
}
