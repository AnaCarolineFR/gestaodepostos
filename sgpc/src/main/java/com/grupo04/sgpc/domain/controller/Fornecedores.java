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
@Table(name="fornecedores")
public class Fornecedores extends EntidadeAbstrata<Long>{
   
    @Column(name="nomeFantasia", nullable = false, length = 100)
    private String nomeFantasia;
    
    @Column(name="razaoSocial", nullable = false, unique = true, length = 100)
    private String razaoSocial;
    
    @Column(name="tipoDocumento", nullable = false, length = 4)
    private String tipoDocumento;
    
    @Column(name="documento", nullable = false, unique = true, length = 50)
    private String documento;
    
    @Column(name="inscricaoEstadual", length = 12)
    private int inscricaoEstadual;
    
    @Column(name="inscricaoMunicipal",  length = 12)
    private int incricaoMunicipal;
    
    @Column(name="observacao")
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name="id_FornecedorTipo")
    private FornecedoresTipos fornecedorTipo; 
    
    
    
    
}
