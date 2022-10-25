/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Empresas;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface EmpresaService {
    
    public void salvar(Empresas empresa);
    public void alterar(Empresas empresa);
    public void excluir(Long id);
    Empresas pesquisarId(Long id);
    List<Empresas> pesquisarTodos();
}
