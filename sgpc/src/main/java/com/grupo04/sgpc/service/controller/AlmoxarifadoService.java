/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Almoxarifados;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface AlmoxarifadoService {
    
    public void salvar(Almoxarifados almoxarifado);
    public void alterar(Almoxarifados almoxarifado);
    public void excluir(Long id);
    public Almoxarifados pesquisarId(Long id);
    public List<Almoxarifados> pesquisarTodos();

    public boolean Almoxarifados(Long id);
}
