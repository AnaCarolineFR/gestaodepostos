/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Cargos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface CargoService {
    
    public void salvar(Cargos cargo);
    public void alterar(Cargos cargo);
    public void excluir(Long id);
    public Cargos pesquisarId(Long id);
    public List<Cargos> pesquisarTodos();

    public boolean usuarioCargos(Long id);
}
