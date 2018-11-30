<%@include file="jspf/cabecalho.jspf" %>

<title>P�gina Inicial</title>
</head>
<body>
    <div class="container-fluid">
        <h4>Veja a categoria e seus respectivos trabalhos:</h4><br/>
    </div>
    <div class="container-fluid" id="categorias">
        =
        <table class="table">
            <thead>
                <tr>
                    <th colspan="4" class="text-center"><h3>${categoria.categoria}</h3></th>
                </tr>
                <tr class="text-center">
                    <th>T�tulo do Jogo</th>
                    <th>Descri��o </th>
                    <th>Criador</th>
                    <th>Avalia��o Final</th>
                    <th>Op��es</th>
                </tr>
            </thead>
            <tbody>

                <c:choose>
                    <c:when test="${not empty categoria.itens}">
                        <c:forEach var="item" items="${categoria.itens}">
                            <tr class="text-center">
                                <td>${item.titulo}</td>
                                <td>${item.descricao}</td>
                                <td>${item.usuario.nome}</td>
                                <td>${item.avaliacaofinal}</td>
                                <td><a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

    <br/>
    <br/>
    <br/>
    <%@include file="jspf/rodape.jspf" %>
