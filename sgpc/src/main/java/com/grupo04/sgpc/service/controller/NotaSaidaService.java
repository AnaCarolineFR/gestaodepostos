/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.NotasSaidas;
import java.util.List;

/**
 *
 * @author rafael-d
 */
public interface NotaSaidaService {
        
    public void salvar(NotasSaidas notaSaida);
    public void alterar(NotasSaidas notaSaida);
    public void excluir(Long id);
    public NotasSaidas pesquisarId(Long id);
    public List<NotasSaidas> pesquisarTodos();
}
