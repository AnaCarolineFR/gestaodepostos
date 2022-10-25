/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.conversor;

import com.grupo04.sgpc.domain.controller.Empresas;
import com.grupo04.sgpc.service.controller.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
/**
 *
 * @author rafael-d
 */

@Component
public class StringToEmpresaConverter implements Converter<String, Empresas>{

    @Autowired
    private EmpresaService service;
    
    @Override
    public Empresas convert(String s) {
        if(s.isEmpty()){
            return null;
        }else{
            Long id = Long.valueOf(s);
            return service.pesquisarId(id);
        }
    }
    
}
