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
@Table(name="produtos")
public class Produtos extends EntidadeAbstrata<Long> {
    
    @Column(name="descricao", nullable = false, unique = true )
    private String descricao;
    
    @Column(name="gtin", unique = true)
    private Long gtin;
    
    @Column(name="ncm" )
    private int ncm;
    
    @Column(name="pesoBruto", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double pesoBruto;
    
    @Column(name="pesoLiquido", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double pesoLiquido;
    
    @Column(name="precoVenda", nullable = false, columnDefinition = ("Decimal(6,2)"))
    private Double precoVenda;
    
    @ManyToOne
    @JoinColumn(name="id_unidade")
    private Unidades unidade;
    
    @ManyToOne
    @JoinColumn(name="id_almoxarifado")
    private Almoxarifados almoxarifado;
    
    //INICIO GETTERS E SETTERS

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        this.gtin = gtin;
    }

    public int getNcm() {
        return ncm;
    }

    public void setNcm(int ncm) {
        this.ncm = ncm;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Unidades getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidades unidade) {
        this.unidade = unidade;
    }

    public Almoxarifados getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifados almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    
    
}
