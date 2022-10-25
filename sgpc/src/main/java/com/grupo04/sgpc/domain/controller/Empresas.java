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
@Table(name="empresas")
public class Empresas extends EntidadeAbstrata<Long> {
   
    @Column(name="nomeFantasia", nullable=false ,unique=true, length=50)
    private String nomeFantasia;
    
    //INICIO GETTERS E SETTERS

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
}
