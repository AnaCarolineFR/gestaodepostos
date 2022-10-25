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
@Table(name="combustiveis_livros")
public class CombustiveisLivros extends EntidadeAbstrata<Long> {
        
    @Column(name="tipo", nullable = false, length = 12)
    private String tipo;
    
    @Column(name="documento", unique = true ,nullable = false)
    private Long documento;
    
    @Column(name="dtMovimentacao", nullable = false)
    private Date dtMovimentacao;
    
    @Column(name="qtdMovimentacao", nullable = false, columnDefinition = "Decimal(8,3)" )
    private Double qtdMovimentacao;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produtos produto; 
    
}
