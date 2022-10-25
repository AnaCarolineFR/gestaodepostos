/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author rafael-d
 */
public interface JPACombustivelTanque extends JpaRepository<CombustiveisTanques, Long> {

    @Query("select c from CombustiveisTanques c where c.id in (select min(m.id) from CombustiveisTanques m group by m.descricao)")
    List<CombustiveisTanques> searchDescriptionDistinct();
    
    @Query("select c from CombustiveisTanques c where c.descricao like ':bomba' and c.produto.id = :id")
    CombustiveisTanques searchFuel(String bomba, Long id);
}
