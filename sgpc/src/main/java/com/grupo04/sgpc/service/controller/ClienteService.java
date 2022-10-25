/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Clientes;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface ClienteService {
    
    public void salvar(Clientes cliente);
    public void alterar(Clientes cliente);
    public void excluir(Long id);
    public Clientes pesquisarId(Long id);
    public List<Clientes> pesquisarTodos();
    
}
