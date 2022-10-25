/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.conversor;

import com.grupo04.sgpc.domain.controller.VendasCombustiveis;
import com.grupo04.sgpc.service.controller.VendaCombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author rafael-d
 */
public class StringToVendaCombustivelConverter implements Converter<String, VendasCombustiveis>{

    @Autowired
    private VendaCombustivelService service;
    
    @Override
    public VendasCombustiveis convert(String s) {
       if(s.isEmpty()){
           return null;
       }
       
       Long id = Long.valueOf(s);
       return service.pesquisarId(id);
    }
    
}
