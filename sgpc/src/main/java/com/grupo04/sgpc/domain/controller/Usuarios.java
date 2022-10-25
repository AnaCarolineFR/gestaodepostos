/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.domain.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 *
 * @author rafael-d
 */

@Entity
@Table(name="usuarios", indexes = {@Index(name="idx_apelidoUsuario", columnList="apelidoUsuario")})
public class Usuarios extends EntidadeAbstrata<Long>{
    
    @Column(name="nomeUsuario", nullable = false, length = 80)
    private String nomeUsuario;
    
    @Column(name="rgUsuario", nullable = false, unique = true, length = 13 )
    private String rgUsuario;
    
    @Column(name="cpfUsuario", nullable = false, unique = true, length = 14)
    private String cpfUsuario;
    
    @Column(name="apelidoUsuario", nullable = false, unique = true, length = 30)
    private String apelidoUsuario;
    
    @JsonIgnore
    @Column(name="senhaUsuario", nullable = false, length = 100)
    private String senhaUsuario;
    
    private String senhaConfirmaUsuario;
    
    @Column(name="dicaSenha", nullable = false, length = 50)
    private String dicaSenha;
    
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresas empresa;
    
    @OneToOne
    @JoinColumn(name="id_cargo")
    private Cargos cargo; 
    
    //INICIO GETTERS E SETTERS

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getRgUsuario() {
        return rgUsuario;
    }

    public void setRgUsuario(String rgUsuario) {
        this.rgUsuario = rgUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getApelidoUsuario() {
        return apelidoUsuario;
    }

    public void setApelidoUsuario(String apelidoUsuario) {
        this.apelidoUsuario = apelidoUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getDicaSenha() {
        return dicaSenha;
    }

    public void setDicaSenha(String dicaSenha) {
        this.dicaSenha = dicaSenha;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public String getSenhaConfirmaUsuario() {
        return senhaConfirmaUsuario;
    }

    public void setSenhaConfirmaUsuario(String senhaConfirmaUsuario) {
        this.senhaConfirmaUsuario = senhaConfirmaUsuario;
    }

    //INICIO CONSTRUTORES
    
    
}
