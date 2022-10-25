/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.FornecedoresTipos;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface FornecedorTipoService {

    public void salvar(FornecedoresTipos fornecedorTipo);
    public void alterar(FornecedoresTipos fornecedorTipo);
    public void excluir(Long id);
    public FornecedoresTipos pesquisarId(Long id);
    public List<FornecedoresTipos> pesquisarTodos();    
}
