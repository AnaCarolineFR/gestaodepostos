/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.NotasEntradas;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface NotaEntradaService {
    
    public void salvar(NotasEntradas notaEntrada);
    public void alterar(NotasEntradas notaEntrada);
    public void excluir(Long id);
    public NotasEntradas pesquisarId(Long id);
    public List<NotasEntradas> pesquisarTodos();
}
