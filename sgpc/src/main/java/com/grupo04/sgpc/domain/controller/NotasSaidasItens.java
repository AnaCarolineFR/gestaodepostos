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
@Table(name="notas_saidas_itens")
public class NotasSaidasItens extends EntidadeAbstrata<Long>{
    
    @Column(name="quantidade", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double quantidade;
    
    @Column(name="vlrUnitario", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrUnitario;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="dtCadastro", nullable = false )
    private Date dtCadastro;
    
    @ManyToOne
    @JoinColumn(name="id_nota_saida")
    private NotasSaidas notasaida;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produtos produto;
   
    
}
