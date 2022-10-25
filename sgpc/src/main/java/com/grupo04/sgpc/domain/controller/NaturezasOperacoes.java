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
@Table(name="naturezas_operacoes")
public class NaturezasOperacoes extends EntidadeAbstrata<Long>{
    
    @Column(name="descricao", nullable = false, unique = true, length = 50)
    private String descricao;
}
