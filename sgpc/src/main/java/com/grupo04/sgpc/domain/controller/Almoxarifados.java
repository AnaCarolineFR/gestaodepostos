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
@Table(name="almoxarifados")
public class Almoxarifados extends EntidadeAbstrata<Long>{
    
    @Column(name="descricao", unique = true, nullable = false, length = 30)
    private String descricao;
    
    @Column(name="abreviacao",unique = true, nullable = false, length = 12)
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
