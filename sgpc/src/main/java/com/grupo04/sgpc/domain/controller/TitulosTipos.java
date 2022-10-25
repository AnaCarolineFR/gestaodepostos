/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.domain.controller;

import javax.persistence.*;

/**
 *
 * @author rafael-d
 */

@Entity
@Table(name="titulos_tipos")
public class TitulosTipos extends EntidadeAbstrata<Long>{
    
    @Column(name="descricao", nullable = false, unique = true, length = 50)
    private String descricao;
    
    //pagar, receber
    @Column(name="tipo", nullable = false, length = 12)
    private String tipo;
}
