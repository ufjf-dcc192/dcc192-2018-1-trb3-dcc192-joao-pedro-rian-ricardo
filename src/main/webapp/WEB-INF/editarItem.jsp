
<%@include file="jspf/cabecalho.jspf" %>
<title>Editar o item</title>
</head>
<body>
    <br/>
<center><h3>Edite abaixo os dados do Item</h3></center>

<div class="container-fluid col-lg-6">
    <form method="post">
        <div class="form-group">
            <input type="hidden" value="${item.id}" name="idItem"/>
            <label>Título do Item:</label>
            <input class="form-control" type="text" placeholder="Insira aqui o título do item a ser discutido" name="titulo" value="${item.titulo}"/><br/>

            <label>Descrição do Item:</label>
            <input class="form-control" type="text" placeholder="Insira aqui uma pequena descrição sobre o item a ser discutido" name="descricao" value="${item.descricao}"/><br/>
            <label>Informe o link e clique em adicionar:</label>
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Insira aqui o link a ser vinculado ao item" id="link"/><br/>
                <span class="input-group-btn">
                    <button class="btn btn-primary" type="button" id="add">Adicionar</button>
                    <button class="btn btn-warning" type="button" id="remove">Remover</button>
                </span>
            </div>
            <label>Links</label>
            <select class="form-control" multiple="multiple" name="links" id="links">
                <c:forEach var="link" items="${item.links}">
                    <option value="${link.link}">${link.link}</option>
                </c:forEach>
            </select>
            <br/>



            <input type="hidden" value="${usuario}" name="usuario">
            <input type="submit" class="btn btn-success" id="enviar"/>
            <input type="reset" class="btn btn-danger"/>
        </div>
    </form>
</div>
<div class="col"></div>



<br/>
<br/>
<script type="text/javascript">
    $("#add").click(function () {
        $('#links').append($('<option>', {
            value: $('#link').val(),
            text: $('#link').val()
        }));
        $('#link').val("");
        $('#link').focus();

    });

    $("#remove").click(function () {
        $('#links option:selected').remove();
        $('#link').val("");
        $('#link').focus();

    });
    $("#enviar").click(function () {
        $("#links option").each(function () {
            $(this).prop('selected', true);
        }
        );

        $("#links").prop('required', true);
    });
</script>
<%@include file="jspf/rodape.jspf" %>
