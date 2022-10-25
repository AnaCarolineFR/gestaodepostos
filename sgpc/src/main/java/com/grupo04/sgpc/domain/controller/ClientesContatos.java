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
@Table(name="clientes_contatos")
public class ClientesContatos extends EntidadeAbstrata<Long>{
    
    //comercial, residencial, recado
    @Column(name="tipo", nullable = false, length = 3)
    private Integer tipo;
    
    //telefone, celular, fax, email
    @Column(name="meio", nullable = false, length = 12)
    private String meio;
    
    //nome do contato
    @Column(name="nome", nullable = false, length = 50)
    private String nome;
    
    //faturamento, maling, recado
    @Column(name="referencia", length = 50)
    private String referencia;
    
    //gerente, comprador, vendedor
    @Column(name="contato", length = 12)
    private String contato;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Clientes cliente;
    
    //Inicio Getters e Setters

   
    
}
