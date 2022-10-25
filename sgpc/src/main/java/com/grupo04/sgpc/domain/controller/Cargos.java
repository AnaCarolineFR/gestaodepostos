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
@Table(name="cargos")
public class Cargos extends EntidadeAbstrata<Long>{
            
    @Column(name="descricao", nullable=false ,unique=true, length=50)
    private String descricao;
    
    @Column(name="tipo", nullable=false, length = 3)
    private String tipo;
    
    //INICIO GETTERS E SETTERS

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
