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
@Table(name="vendas_produtos")
public class VendasProdutos extends EntidadeAbstrata<Long>{
    
    @Column(name="comanda", nullable = false, length = 8)
    private int comanda;
    
    //Situacao = A(Aberto), B(Bloqueada), C(Cancelada), E(Encerrada)
    @Column(name="situacao", nullable = false, length = 1)
    private String situacao;
    
    @Column(name="dtAbertura", nullable = false)
    private Date dtAbertura;
    
    @Column(name="dtAlteracao", nullable = true)
    private Date dtAlteracao;
    
    @Column(name="dtEncerramento", nullable = true)
    private Date dtEncerramento;
    
    @Column(name="vlrTotal", nullable = true)
    private double vlrTotal;
    
    @Column(name="qtdTotal", nullable = true)
    private int qtdTotal;
    
    
    //INICIO GETTERS E SETTERS

    public int getComanda() {
        return comanda;
    }

    public void setComanda(int comanda) {
        this.comanda = comanda;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public Date getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(Date dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }
    
    
}
