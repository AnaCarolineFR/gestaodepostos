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
@Table(name="notas_saidas")
public class NotasSaidas extends EntidadeAbstrata<Long>{
    
    @Column(name="numero", nullable = false, unique = true)
    private int numero;
    
    @Column(name="serie", nullable = false )
    private String setie;
    
    @Column(name="dtEmissao", nullable = false)
    private Date dtEmissao;
    
    @Column(name="pesoLiquido", columnDefinition = ("Decimal(4,2)") )
    private Double pesoLiquido;
    
    @Column(name="pesoBruto", columnDefinition = ("Decimal(4,2)") )
    private Double pesoBruto;
    
    @Column(name="bcIcms", columnDefinition = ("Decimal(4,2)") )
    private Double bcIcms;
    
    @Column(name="vlrIcms", columnDefinition = ("Decimal(4,2)") )
    private Double vlrIcms;
    
    @Column(name="bcIcmsSt", columnDefinition = ("Decimal(4,2)") )
    private Double bcIcmsSt;
    
    @Column(name="vlrIcmsSt", columnDefinition = ("Decimal(4,2)") )
    private Double vlrIcmsSt;
    
    @Column(name="vlrFrete", columnDefinition = ("Decimal(4,2)") )
    private Double vlrFrete;
    
    @Column(name="vlrSeguro", columnDefinition = ("Decimal(4,2)") )
    private Double vlrSeguro;
    
    @Column(name="vlrDesconto", columnDefinition = ("Decimal(4,2)") )
    private Double vlrDesconto;
    
    @Column(name="vlrIpi", columnDefinition = ("Decimal(4,2)") )
    private Double vlrIpi;
    
    @Column(name="vlrTotal", columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="vlrTotalComImpostos", columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotalComImpostos;
    
    @OneToOne
    @JoinColumn(name="id_natureza")
    private NaturezasOperacoes natureza;
    
    @OneToOne
    @JoinColumn(name="id_frete")
    private FretesTipos frete;
    
    @OneToOne
    @JoinColumn(name="id_cliente")
    private Clientes cliente;
    
    @OneToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedores fornecedor;
        
    @OneToOne
    @JoinColumn(name="id_empresa")
    private Empresas empresa;
    

    
}
