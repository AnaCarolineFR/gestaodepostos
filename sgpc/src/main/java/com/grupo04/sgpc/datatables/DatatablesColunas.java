/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.datatables;

/**
 *
 * @author rafael-d
 */
public class DatatablesColunas {
    
    public static final String[] COMANDA = {"id","comanda", "situacao", "dtAbertura", "dtAlteracao", "dtEncerramento"};
    public static final String[] ITENSCOMANDA = {"id", "item", "quantidade", "vlrUnitario", "vlrTotal", "produto.descricao", "vendaProduto.id", "usuario.id", "dtAlteracao", "dtInclusao"};
    public static final String[] PRODUTO = {"id","descricao", "gtin", "ncm", "pesoBruto", "pesoLiquido", "unidade.abreviacao", "precoVenda", "almoxarifado.descricao" };
}
