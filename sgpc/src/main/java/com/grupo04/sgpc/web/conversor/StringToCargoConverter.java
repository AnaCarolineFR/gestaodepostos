/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.conversor;

import com.grupo04.sgpc.domain.controller.Cargos;
import com.grupo04.sgpc.service.controller.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author rafael-d
 */

@Component
public class StringToCargoConverter implements Converter<String, Cargos>{

    @Autowired
    private CargoService service;
    
    @Override
    public Cargos convert(String s) {
        if(s.isEmpty()){
            return null;
        }
       Long id = Long.valueOf(s);
       return service.pesquisarId(id); 
    }
}
