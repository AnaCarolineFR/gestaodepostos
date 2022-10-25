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
@Table(name="condicoes_pagamentos")
public class CondicoesPagamentos extends EntidadeAbstrata<Long>{
    
    @Column(name="descricao", nullable = false, unique = true, length = 50)
    private String descricao;
    
    @Column(name="tipo", nullable = false, unique = true, length = 12)
    private String tipo;
    
    @Column(name="qtdParcelas", nullable = false, length = 2)
    private int qtdParcelas;
    
}
