/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.CombustiveisTanques;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafael-d
 */

@Repository
public class CombustivelTanqueDI extends DAOAbstrata<CombustiveisTanques,Long> implements DAOCombustivelTanque {

    @Override
    public List<CombustiveisTanques> findDistinctDescription() {
        return createQuery("select distinct c.descricao from CombustiveisTanques c where c.id > ?1", 0);
    }
   
}
