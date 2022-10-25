/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Usuarios;
import java.util.List;

/**
 *
 * @author rafael-d
 */

public interface UsuarioService {
  
    public void salvar(Usuarios usuario);
    public void alterar(Usuarios usuario);
    public void excluir(Long id);
    Usuarios pesquisarId(Long id);
    List<Usuarios> pesquisarTodos();

    public List<Usuarios> pesquisaPorApelido(String apelidoUsuario);
    
}
