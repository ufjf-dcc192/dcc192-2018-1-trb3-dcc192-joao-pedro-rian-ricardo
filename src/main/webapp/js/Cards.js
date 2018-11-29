var addCols = function (categorias) {
    var getUrl = window.location;
    var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
    for (let i = 0; i < categorias.length; i++) {
        let categoria = $('<div class="col-lg-12"><h4>Categoria: '+categorias[i].categoria+'</h4></div>');
        if (categorias[i].itens.length>0) {
            let itens = categorias[i].itens;
            for (let i = 0; i < itens.length; i++) {
                let botaoEnvio = document.createElement('button');
                botaoEnvio.type = "button";
                botaoEnvio.className = "btn btn-light";
                botaoEnvio.id = i;
                botaoEnvio.title = "Ver Detalhes do Jogo";
                botaoEnvio.textContent = "Ver Detalhes do Jogo";
                botaoEnvio.addEventListener('click', function () {
                    window.location.href = baseUrl + "/item.html?idItem=" + itens[i].id;
                });
                let myCol = $('<div class="col-sm-12 col-md-6 col-lg-6 pb-2"></div>');
                let myPanel = $('<div class="card text-white bg-success mb-4" style="max-width: 18rem">'
                        + '<div class="card-header"><h4>' + itens[i].titulo + '</h4></div>'
                        + '<div class="card-body" id="body' + i + '">'
                        + '<h6>Descrição: ' + itens[i].descricao + '</h6>'
                        + '<h6>Criador: ' + itens[i].usuario.nome + '</h6>'
                        + '</div>'
                        + '</div>');

                
                myPanel.appendTo(myCol);
                categoria.appendTo('#categorias');
                myCol.appendTo('#categorias');
                document.getElementById("body" + i).append(botaoEnvio);
            }
        }else{
             let mensagem = $('<div class="col-lg-12"><h4>Não jogos cadastrados nessa categoria</h4></div>');
             categoria.appendTo('#categorias');
             mensagem.appendTo('#categorias');
        }
       
    }
};


$(document).ready(function () {
    addCols(categorias);
});

function enviaEmail(id, nome, email, idUsuario) {
    $("#" + id).text("Enviando Convite. Aguarde...");
    $("#" + id).prop("disabled", true);
    var grupo = sessionStorage.getItem("grupo");
    $.ajax({
        url: 'ajaxEmail.html',
        data: {
            nome: nome,
            email: "validatorsearch@gmail.com",
            contexto: contexto,
            login: email,
            id: idUsuario,
            idGrupo: grupo
        },
        type: 'post',
        success: function (data) {
            $("#" + id).text("Convite Enviado");
        }
    });

}



