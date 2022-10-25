/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.service.controller;

import com.grupo04.sgpc.dao.controller.DAOProduto;
import com.grupo04.sgpc.dao.controller.JPAProduto;
import com.grupo04.sgpc.dao.controller.ProdutoDI;
import com.grupo04.sgpc.domain.controller.Produtos;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rafael-d
 */

@Service
public class ProdutoSI implements ProdutoService{
    
    @Autowired
    private DAOProduto dao;
    
    @Autowired
    private ProdutoDI diProduto;
    
    @Transactional(readOnly=false)
    @Override
    public void salvar(Produtos produto) {
        dao.save(produto);
    }

    @Transactional(readOnly=false)
    @Override
    public void alterar(Produtos produto) {
        dao.update(produto);
    }

    @Transactional(readOnly=false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Produtos pesquisarId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Produtos> pesquisarTodos() {
        return dao.findAll();
    }

    private String[] cols = {
       "id", "descricao", "gtin", "ncm", "pesoBruto", "pesoLiquido", "preco_venda", "unidade.abreviacao"
    };
    
    @Transactional(readOnly = true)
    public Map<String, Object> execute(JPAProduto jpa, HttpServletRequest request){
        
        Map<String, Object> json = new LinkedHashMap<>();
        
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        int draw = Integer.parseInt(request.getParameter("draw"));
        int current = currentPage(start, length);
        String column = columnName(request);
        Sort.Direction direction = OrderBy(request);
        Pageable pageable = PageRequest.of(current, length, direction, column);
        Page<Produtos> page = queryBy(jpa, pageable);
        
        json.put("draw", draw);
        json.put("recordsTotal", page.getTotalElements());
        json.put("recordFiltered",page.getTotalElements());
        json.put("data", page.getContent());

        return json;
    }

    private int currentPage(int start, int lenght) {
        return start/lenght;
    }

    private String columnName(HttpServletRequest request) {
        int iCol = Integer.parseInt(request.getParameter("order[0][column]"));
        return cols[iCol];
    }

    private Sort.Direction OrderBy(HttpServletRequest request) {
        String order = request.getParameter("order[0][dir]");
        Sort.Direction sort = Sort.Direction.ASC;
        if(order.equalsIgnoreCase("desc")){
            sort = Sort.Direction.DESC;
        }
        return sort;
    }

    private Page<Produtos> queryBy(JPAProduto jpa, Pageable pageable) {
        return jpa.findAll(pageable);
    }

   @Transactional(readOnly = true)
   public Produtos pesquisarProduto(Long gtin){
   Produtos p = new Produtos();
   List<Produtos> lista = diProduto.pesquisaPorGtin(gtin);
   if(lista.size() > 0){
       p.setId(lista.get(0).getId());
       p.setDescricao(lista.get(0).getDescricao());
       p.setGtin(lista.get(0).getGtin());
       p.setNcm(lista.get(0).getNcm());
       p.setPesoBruto(lista.get(0).getPesoBruto());
       p.setPesoLiquido(lista.get(0).getPesoLiquido());
       p.setPrecoVenda(lista.get(0).getPrecoVenda());
       p.setAlmoxarifado(lista.get(0).getAlmoxarifado());
       p.setUnidade(lista.get(0).getUnidade());
       return p;
    }
    return p;
   }
}
