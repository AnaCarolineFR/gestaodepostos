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
@Table(name="unidades")
public class Unidades extends EntidadeAbstrata<Long>{
        
    @Column(name="descricao", nullable = false, unique = true, length = 50)
    private String descricao;
    
    @Column(name="abreviacao", nullable = false, unique = true, length = 3)
    private String abreviacao;

    //INICIO GETTERS E SETTERS
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
    
    
}
