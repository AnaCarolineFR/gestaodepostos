/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.web.conversor;

import com.grupo04.sgpc.domain.controller.Almoxarifados;
import com.grupo04.sgpc.service.controller.AlmoxarifadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author rafael-d
 */
@Component
public class StringToAlmoxarifadoConverter implements Converter<String, Almoxarifados> {

    @Autowired
    private AlmoxarifadoService service;

    @Override
    public Almoxarifados convert(String s) {
        if(s.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(s);
        return service.pesquisarId(id);
    }
    
}
