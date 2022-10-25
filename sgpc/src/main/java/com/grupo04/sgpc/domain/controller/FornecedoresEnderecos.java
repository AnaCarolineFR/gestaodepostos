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
@Table(name="fornecedores_enderecos")
public class FornecedoresEnderecos extends EntidadeAbstrata<Long>{
    
    @Column(name="tipo", nullable = false, length = 2)
    private String tipo;
    
    @Column(name="logradouro", nullable = false)
    private String logradouro;
    
    @Column(name="numero",nullable = false, length = 12)
    private String numero;
    
    @Column(name="complemento", nullable = false)
    private String complemento;
    
    @Column(name="bairro", nullable = false, length = 50)
    private String bairro;
    
    @Column(name="municipio", nullable = false, length = 50)
    private String municipio;
    
    @Column(name="uf", nullable = false, length = 2)
    private String uf;
    
    @Column(name="cep", nullable = false, length = 9)
    private String cep;
    
    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    private Fornecedores fornecedor;
}
