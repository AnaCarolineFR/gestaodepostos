/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author rafael-d
 */
public class CriptografaSenha {
    
    public void CriptografaSenha(String senha){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
