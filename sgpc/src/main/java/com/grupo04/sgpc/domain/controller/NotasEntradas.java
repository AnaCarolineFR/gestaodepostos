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
@Table(name="notas_entradas")
public class NotasEntradas extends EntidadeAbstrata<Long>{
    
    @Column(name="numero", nullable = false, length = 12)
    private int numero;
    
    @Column(name="serie", nullable = false, length = 5)
    private String serie;
    
    @Column(name="dtCadastro", nullable = false)
    private Date dtCadastro;
    
    @Column(name="dtAlteracao", nullable = false)
    private Date dtAlteracao;
    
    @Column(name="dtEmissao", nullable = false)
    private Date emissao;
    
    @Column(name="dtRecebimento", nullable = false)
    private Date dtRecebimento;
    
    @Column(name="bcIcms", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double bcIcms;
    
    @Column(name="vlrIcms", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIcms;
    
    @Column(name="bcIcmsSt", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double bcIcmsSt;
    
    @Column(name="vlrIcmsSt", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIcmsSt;
    
    @Column(name="bcIpi", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double bcIpi;
    
    @Column(name="vlrIpi", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIpi;
    
    @Column(name="vlrInss", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrInss;
    
    @Column(name="vlrIrrf", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIrrf;
    
    @Column(name="vlrIss", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrIss;
    
    @Column(name="vlrPis", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrPis;
    
    @Column(name="vlrCofins", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrCofins;
    
    @Column(name="vlrTotal", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double vlrTotal;
    
    @Column(name="chaveAcesso", unique = true )
    private Double chaveAcesso;
    
    @OneToOne
    @JoinColumn(name="id_natureza")
    private NaturezasOperacoes natureza;
    
    @OneToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedores fornecedor;
    
}
