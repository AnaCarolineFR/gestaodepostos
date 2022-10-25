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
@Table(name="titulos_receber")
public class TitulosReceber extends EntidadeAbstrata<Long>{

    @Column(name="situacao", nullable = false,length = 2 )
    private Double situacao;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="dtCadastro", nullable = false )
    private Date dtCadastro;
    
    @Column(name="dtAlteracao", nullable = false )
    private Date dtAlteracao;
    
    @Column(name="dtEmissao", nullable = false )
    private Date dtEmissao;
    
    @Column(name="saldo", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double saldo;
    
    @OneToOne
    @JoinColumn(name="id_nota_saida")
    private NotasSaidas notasaida;
    
    @OneToOne
    @JoinColumn(name="id_titulo_tipo")
    private TitulosTipos titulotipo;
    
    @OneToOne
    @JoinColumn(name="id_condicao")
    private CondicoesPagamentos condicao;
}
