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
@Table(name="clientes")
public class Clientes extends EntidadeAbstrata<Long>{
    
    @Column(name="tipo", nullable = false, length = 12)
    private String tipo;
    
    @Column(name="nome", nullable = false, length = 80)
    private String nome;
    
    @Column(name="tipoDocumento", nullable = false, length = 4)
    private String tipoDocumento;
    
    @Column(name="documento",unique = true,  nullable = false, length = 30)
    private String documento;
    
    @Column(name="sexo", length = 1)
    private String sexo;
    
    @Column(name="dtNascimento")
    private Date dtNascimento;
    
    @Column(name="dtCadastro", nullable = false)
    private Date dtCadastro;
    
    @Column(name="dtAlteracao", nullable = false)
    private Date dtAlteracao;
    
    
    
    
    
    
}
