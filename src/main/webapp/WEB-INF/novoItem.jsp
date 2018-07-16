
<%@include file="jspf/cabecalho.jspf" %>
<title>Crie um novo item</title>
</head>
<body>
    <br/>
<center><h3>Insira abaixo os dados solicitados para a criação de um novo Item</h3></center>

<div class="container-fluid">
    <form method="post">
        <div class="form-group">
            <label>Título do Item:</label>
            <input class="form-control" type="text" placeholder="Insira aqui o título do item a ser discutido" name="titulo"/><br/>

            <label>Descrição do Item:</label>
            <input class="form-control" type="text" placeholder="Insira aqui uma pequena descrição sobre o item a ser discutido" name="descricao"/><br/>




            <input type="hidden" value="${usuario}" name="usuario">
            <input type="submit" class="btn btn-success"/>
            <input type="reset" class="btn btn-danger"/>
        </div>
    </form>
</div>
<div class="col"></div>



<br/>
<br/>
<%@include file="jspf/rodape.jspf" %>
