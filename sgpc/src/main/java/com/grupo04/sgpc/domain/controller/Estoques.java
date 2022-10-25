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
@Table(name="estoques")
public class Estoques extends EntidadeAbstrata<Long>{
    
    @Column(name="qtdMinima", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double qtdMinima;
    
    @Column(name="qtdMaxima", nullable = false, columnDefinition = ("Decimal(4,2)") )
    private Double qtdMaxima;
    
    @Column(name="saldo", nullable = false,  columnDefinition = "Decimal(8,3)")
    private Double saldo;
    
    @Column(name="dtCadastro", nullable = false)
    private Date dtCadastro;
    
    @Column(name="dtAlteracao", nullable = false)
    private Date dtAlteracao;
    
    @ManyToOne
    @JoinColumn(name="id_almoxarifado")
    private Almoxarifados almoxarifado;
    
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresas empresa;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produtos produto;
    
    
    
}
