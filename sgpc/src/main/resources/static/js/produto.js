$(document).ready(function(){
    
    moment.locale('pt-BR');
    $("#table-server").DataTable({
        processing:true,
        serverSide:true,
        responsive:true,
        lengthMenu:[10,25,50,100],
        ajax:{
            url:"/produtos/cadastrar/tabelas",
            data: "data"
        },
        columns: [
            {data: 'id'},
            {data: 'descricao'},
            {data: 'gtin'},
            {data: 'ncm'},
            {data: 'pesoBruto'},
            {data: 'pesoLiquido'},
            {data: 'unidade.abreviacao'},
            {data: 'precoVenda'}
        ]
    });


});