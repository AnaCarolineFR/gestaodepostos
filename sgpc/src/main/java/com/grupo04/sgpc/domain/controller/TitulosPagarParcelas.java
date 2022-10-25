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
@Table(name="titulos_pagar_parcelas")
public class TitulosPagarParcelas extends EntidadeAbstrata<Long>{
    
    @Column(name="situacao", nullable = false, length = 2 )
    private String situacao;
    
    @Column(name="numero", nullable = false, length = 3 )
    private int numero;
    
    @Column(name="dtVencimento", nullable = false )
    private Date dtVencimento;
    
    @Column(name="dtPagamento" )
    private Date dtPagamento;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="vlrPago", columnDefinition = ("Decimal(4,2)") )
    private Double vlrPago;
    
    @Column(name="vlrSaldo", columnDefinition = ("Decimal(4,2)") )
    private Double vlrSaldo;
    
    @ManyToOne
    @JoinColumn(name="id_titulo_pagar")
    private TitulosPagar titulopagar;
    
}
