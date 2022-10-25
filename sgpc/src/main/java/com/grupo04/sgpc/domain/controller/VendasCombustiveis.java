/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.domain.controller;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rafael-d
 */

@Entity
@Table(name="vendas_combustiveis")
public class VendasCombustiveis extends EntidadeAbstrata<Long>{
    
    //A = Aberto, E=Encerrado, C=Cancelado
    @Column(name="situacao", nullable = false, length = 1)
    private String situacao;
    
    @Column(name="vlr_Total", nullable = false)
    private Double vlrTotal;
    
    @Column(name="quantidade", nullable = false)
    private Double quantidade;
    
    @Column(name="dt_abertura", nullable = false)
    private Date dtAbertura;
    
    @Column(name="dt_encerramento", nullable = true)
    private Date dtEncerramento;
    
    @OneToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuarios usuario;
    
    @OneToOne
    @JoinColumn(name="id_combustivel_tanque", nullable = false)
    private CombustiveisTanques combustivelTanque;
    
    @OneToOne
    @JoinColumn(name="id_produto", nullable = false)
    private Produtos produto;
    
    //INICIO GETTERS E SETTERS

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Date getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(Date dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public CombustiveisTanques getCombustivelTanque() {
        return combustivelTanque;
    }

    public void setCombustivelTanque(CombustiveisTanques combustivelTanque) {
        this.combustivelTanque = combustivelTanque;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    
    
}
