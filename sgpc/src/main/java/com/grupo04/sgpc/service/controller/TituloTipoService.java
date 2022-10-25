/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.TitulosTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface TituloTipoService {

    public void salvar(TitulosTipos tituloTipo);
    public void alterar(TitulosTipos tituloTipo);
    public void excluir(Long id);
    public TitulosTipos pesquisarId(Long id);
    public List<TitulosTipos> pesquisarTodos();
}
