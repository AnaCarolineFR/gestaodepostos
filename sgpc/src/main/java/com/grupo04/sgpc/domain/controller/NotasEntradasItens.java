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
@Table(name="notas_entradas_itens")
public class NotasEntradasItens extends EntidadeAbstrata<Long> {
    
    @Column(name="cst", length = 12)
    private int cst;
    
    @Column(name="cfop", length = 12 )
    private int cfop;
    
    @Column(name="quantidade", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double quantidade;
    
    @Column(name="vlrUnitario", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrUnitario;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="aliqIcms", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double aliqIcms;
    
    @Column(name="bcIcms", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double bcIcms;
    
    @Column(name="vlrIcms", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIcms;
    
    @Column(name="aliqIpi", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double aliqIpi;
    
    @Column(name="vlrIpi", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIpi;
    
    @ManyToOne
    @JoinColumn(name="id_nota_entrada")
    private NotasEntradas notaentrada;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produtos produto;
    
    @ManyToOne
    @JoinColumn(name="id_unidade")
    private Unidades unidade;
}
