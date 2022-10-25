/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.domain.controller;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rafael-d
 */

@Entity
@Table(name="combustiveis_tanques")
public class CombustiveisTanques extends EntidadeAbstrata<Long>{
    
    @Column(name="descricao", nullable = false, length = 50)
    private String descricao;
    
    @Column(name="dtCadastro", nullable = false)
    private Date dtCadastro; 
    
    @Column(name="dtValidade", nullable = false)
    private Date dtValidade;
    
    @Column(name="capMaxima", columnDefinition = ("Decimal(8,3)"))
    private Double capMaxima;
    
    @Column(name="capMinima", columnDefinition = ("Decimal(8,3)"))
    private Double CapMinima;
    
    @Column(name="saldo", columnDefinition = ("Decimal(8,3)"))
    private Double saldo;
    
    @Column(name="locPista", length = 12)
    private String locPista;
    
    @Column(name="posicao", length = 2)
    private int posicao;
    
    @OneToOne
    @JoinColumn(name="id_produto")
    private Produtos produto;
    
    @OneToOne
    @JoinColumn(name="id_empresa")
    private Empresas empresa;
    
    //INICIO GETTERS E SETTERS

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public Double getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(Double capMaxima) {
        this.capMaxima = capMaxima;
    }

    public Double getCapMinima() {
        return CapMinima;
    }

    public void setCapMinima(Double CapMinima) {
        this.CapMinima = CapMinima;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getLocPista() {
        return locPista;
    }

    public void setLocPista(String locPista) {
        this.locPista = locPista;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    
}
