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
@Table(name="estoques_movimentacoes")
public class EstoquesMovimentacoes extends EntidadeAbstrata<Long>{
    
    @Column(name="tipoMovimentacao", nullable = false, length = 2)
    private String tipoMovimentacao;
    
    @Column(name="tipoDocumento", nullable = false, length = 12)
    private String tipoDocumento;
    
    @Column(name="numDocumento", nullable = false)
    private int numDocumento;
    
    @Column(name="serieDocumento", nullable = false, length = 3)
    private String serieDocumento;
    
    @Column(name="dtMovimentacao", nullable = false)
    private Date dtMovimentacao;
    
    @Column(name="observacoes", nullable = false)
    private String observacoes;
    
    @Column(name="qtdMovimentacao", nullable = false, columnDefinition = ("Decimal(8,3)"))
    private Double qtdMovimentacao;
    
    @ManyToOne
    @JoinColumn(name="id_estoque")
    private Estoques estoque;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produtos produto;
    
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresas empresa;
}
