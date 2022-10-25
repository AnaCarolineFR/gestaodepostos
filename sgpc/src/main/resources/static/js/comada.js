$(document).ready(function(){
    moment.locale('pt-BR');
    var table = ('#table-consultaComanda').Datatable({
        searching:true,
        order:[[1,"asc"]],
        lengthMenu:[5,10],
        processing: true,
        serverSide: true,
        resposive: true,
        ajax:{
            url:'/loja/datatables/server',
            data: 'data'
        },
        columns:[
            {data: 'id'},
            {data: 'descricao'},
            {data: 'gtin'},
            {data: 'quantidade'},
            {ordenable: false,
                data:'id',
                    "render": function(id){
                        return '<a class="btn btn-success btn-sm btn-block" href="/loja/editar/' + id +'"role="button"><i class="fas fa-edit"></i></a>'
                    }
            }
        ]
    });
});