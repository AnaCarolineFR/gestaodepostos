/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.domain.controller.Cargos;
import com.grupo04.sgpc.domain.controller.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class LoginService implements UserDetailsService{
    
    @Autowired
    private UsuarioService service;
    
    @Transactional(readOnly = true)
    public Usuarios pesquisaPorApelido(String apelidoUsuario){
        Usuarios usuario = new Usuarios();
        List<Usuarios> lista = service.pesquisaPorApelido(apelidoUsuario);
        for(int i=0; i < lista.size(); i++){
            usuario.setId(lista.get(i).getId());
            usuario.setNomeUsuario(lista.get(i).getNomeUsuario());
            usuario.setApelidoUsuario(lista.get(i).getApelidoUsuario());
            usuario.setSenhaUsuario(lista.get(i).getSenhaUsuario());
            usuario.setDicaSenha(lista.get(i).getDicaSenha());
            usuario.setCpfUsuario(lista.get(i).getCpfUsuario());
            usuario.setRgUsuario(lista.get(i).getRgUsuario());
            usuario.setEmpresa(lista.get(i).getEmpresa());
            usuario.setCargo(lista.get(i).getCargo());
        }
        return usuario;
    }

    @Override 
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Usuarios usuario = pesquisaPorApelido(string);
        return new User(
                usuario.getApelidoUsuario(),
                usuario.getSenhaUsuario(),
                //AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getCargo().getTipo())
                AuthorityUtils.createAuthorityList(usuario.getCargo().getTipo())
        );
    }
    
    
    /*
        Metodo para ser utilizado caso o usuário tivesse mais de um cargo.
        Por exemplo: Gerente e Caixa.
    */
    private String[] getAuthorities(List<Cargos> cargo){
        String[] authorities = new String[cargo.size()];
        for(int i = 0; i < cargo.size(); i ++){
            authorities[i] = cargo.get(i).getDescricao();
        }
        return authorities;
    }
}
