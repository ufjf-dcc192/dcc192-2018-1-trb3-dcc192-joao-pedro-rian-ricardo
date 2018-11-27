<%@include file="jspf/cabecalho.jspf" %>

<title>Página Inicial</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col col-lg-3">     
            </div>
            <div class="col col-lg-6">
                <h4>Bem-Vindo, ${usuario.nome}<br/></h4>
                <a href="item-novo.html" class="btn btn-primary">Criar Item de Discussão</a>
                <br/>
                <br/>
            </div>
        </div>
        <div class="row">
                <h4>Veja as categorias e seus respectivos itens:<br/></h4>
                <c:forEach var="categoria" items="categorias">
                        Categoria: ${categoria}
                </c:forEach>
        </div>
    </div>
    <br/>
    <br/>



    <br/>
    <%@include file="jspf/rodape.jspf" %>
