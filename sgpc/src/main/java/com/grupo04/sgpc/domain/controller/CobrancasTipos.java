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
@Table(name="cobrancas_tipos")
public class CobrancasTipos extends EntidadeAbstrata<Long> {
    
    @Column(name="descricao", nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
