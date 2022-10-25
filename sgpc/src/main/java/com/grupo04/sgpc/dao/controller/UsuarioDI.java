/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.dao.controller;

import com.grupo04.sgpc.domain.controller.Usuarios;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafael-d
 */

@Repository
public class UsuarioDI extends DAOAbstrata<Usuarios, Long> implements DAOUsuario{

    @Override
    public List<Usuarios> findByNickname(String apelidoUsuario) {
        return createQuery("select u from Usuarios u where u.apelidoUsuario like ?1",apelidoUsuario);
    }
 
}
