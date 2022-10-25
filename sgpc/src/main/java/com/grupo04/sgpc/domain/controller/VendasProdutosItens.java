/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.domain.controller;

import com.grupo04.sgpc.service.controller.VendaProdutoSI;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rafael-d
 */

@Entity
@Table(name="vendas_produtos_itens")
public class VendasProdutosItens extends EntidadeAbstrata<Long>{
    
    @Column(name="item", nullable = false, length = 8)
    private int item;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(8,4)"))
    private Double vlrTotal;
    
    @Column(name="vlrUnitario", nullable = false, columnDefinition = ("Decimal(8,4)"))
    private Double vlrUnitario;
    
    @Column(name="quantidade", nullable = false, columnDefinition = ("Decimal(8,4)"))
    private Double quantidade;
    
    @Column(name="dtInclusao", nullable = false)
    private Date dtInclusao;
    
    @Column(name="dtAlteracao", nullable = true)
    private Date dtAlteracao;
    
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuarios usuario;
    
    @OneToOne
    @JoinColumn(name="id_venda_produto")
    private VendasProdutos vendaProduto;
    
    @OneToOne
    @JoinColumn(name="id_produto")
    private Produtos produto; 

    //INICIO GETTERS E SETTERS

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(Double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public VendasProdutos getVendaProduto() {
        return vendaProduto;
    }

    public void setVendaProduto(VendasProdutos vendaProduto) {
        this.vendaProduto = vendaProduto;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    
    //INICIO CONSTRUTORES

    public VendasProdutosItens() {
    }

    public VendasProdutosItens(int item, Double vlrTotal, Double vlrUnitario, Double quantidade, Date dtInclusao, Date dtAlteracao, Usuarios usuario, VendasProdutos vendaProduto, Produtos produto) {
        this.item = item;
        this.vlrTotal = vlrTotal;
        this.vlrUnitario = vlrUnitario;
        this.quantidade = quantidade;
        this.dtInclusao = dtInclusao;
        this.dtAlteracao = dtAlteracao;
        this.usuario = usuario;
        this.vendaProduto = vendaProduto;
        this.produto = produto;
    }
    
    //INICIO METODOS
    
    
}
