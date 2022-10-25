$(document).ready(function(){

    $("#chapa").on('keydown', function(e){
        if(e.keyCode == 13){
            e.preventDefault();
            let id = $("#chapa").val(); 
            document.location.href = '/pistas/vendas/existeUsuario/' + id;
        }
    });

    $("#cboTipoCombustivel").on('change', function(e){
        if($("#cboBomba").val() != ""){
            let sBomba = $("#cboBomba option:selected").text();
            let iTipo = $("#cboTipoCombustivel").val();

            $.ajax({
                method: "POST",
                url: "/pistas/vendas/existeCombustivel",
                data:{
                    descricao:"BOMBA 02",
                    produto:"5"
                },
                success: function(data){
                    $("#precoVenda").val(data.produto.precoVenda);
                    $("#unidade").val(data.produto.unidade.descricao);
                    $("#idProduto").val(data.produto.id);
                    $("#idCombustivelTanque").val(data.id);
                },
                error:function(xhr){
                    alert("Erro: " + xhr.responseText)
                }
            })
        }

    })


    $("#abastecer").on('click', function(e){
        e.preventDefault();
        var venda = {};
        venda.quantidade = $("#quantidade").val();
        venda.situacao = "A";
        venda.vlrTotal = $("#valor").val();
        venda.idCombustivelTanque = $("#idCombustivelTanque").val();
        venda.idUsuario = $("#chapa").val();
        venda.idProduto = $("#idProduto").val();

        $.ajax({
            method:"POST",
            url: "/pistas/vendas/abastecimento",
            data: venda,
            success:function(){
                alert("deu certo!")
            }
        })

    })



})