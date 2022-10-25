$(document).ready(function(){

    listarItemComanda();

    //Pesquisa se comanda existe e carrega retorno no form;
    $("#comanda").on('keydown', function(e){
        if(e.keyCode == 13){
            let comanda = $("#comanda").val();
            document.location.href = '/../../lojas/vendas/pesquisaComandas/' + comanda;
        }
    });

    //Pesquisa se produto existe e carrega retorno no form;
    $("#gtin").on('keydown', function(e){
        if(e.keyCode == 13){
            var gtin = $("#gtin").val();
            pesquisaProduto(gtin);
        }
    });

    //Botão para inclusão da comanda e dos produtos nas comandas;
    //Não está sendo utilizado porque está duplicando as comandas.
    $("#btnIncluir").on('click', function(e){

        let id = $("#id").val();
        let idProd = $("#id-prod").val();

        if(id > 0 & idProd > 0){
            alert(id + "-" + idProd);
            alert("Comanda e produtos inseridos!");
        }else if(id == 0 & idProd > 0){
            alert(id + "-" + idProd);
            alert("Falta id da comanda, é necessário primeiro abrir a comanda.");
        }else{
            alert(id + "-" + idProd)
            alert("Está criando uma comanda vazia.")
            addComanda();

        }
    })

    //Método que adiciona uma comanda vazia.
    function addComanda(){
        var vendasProdutos = {};
        vendasProdutos.situacao = "A";
        console.log(">> objeto", vendasProdutos);
        $.ajax({
            method: "POST",
            url:'/lojas/vendas/addComanda',
            data: vendasProdutos,
            success: function(){

                $("#alert").addClass("alert alert-success").text("Comanda aberta com sucesso!");
            },
            error: function(xhr){
                console.log(">> erro:", xhr.responseText);
                $("#alert").addClass("alert alert-danger").text("Não foi possivel abrir a comanda, tente novamente.");
            }
        })
    }

    // //Metodo que adiciona item à comanda selecionada.
    // function addProduto(){

    // }

    function pesquisaProduto(gtin){
        $.ajax({
            method: "GET",
            url: '/lojas/vendas/pesquisaProdutos/' + gtin,
            data: {"gtin": gtin} ,
            success: function(data){
                $("#id-prod").val(data.id),
                $("#descricao").val(data.descricao),
                $("#precoVenda").val(data.precoVenda)
            },
            error:function(e){
                alert(e);
            }
        })
    }

    function listarItemComanda(){
        if($("#id").val() > 0){
            var id = $("#id").val();
            $("#table-comanda").DataTable({
                processing:true,
                serverSide:true,
                responsive:true,
                lengthMenu:[5,10,25],
                ajax:{
                    url:"/lojas/vendas/server/" + id,
                    data:"data"
                },
                columns:[
                    {data:'id'},
                    {data:'item'},
                    {data:'produto.descricao'},
                    {data:'produto.gtin'},
                    {data:'quantidade'},
                    {data:'vlrUnitario'},
                    {data:'vlrTotal'}
                ]
            })
        }
    }



});