/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.FretesTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface FreteTipoService {
    
    public void salvar(FretesTipos freteTipo);
    public void alterar(FretesTipos freteTipo);
    public void excluir(Long id);
    public FretesTipos pesquisarId(Long id);
    public List<FretesTipos> pesquisarTodos();
}
