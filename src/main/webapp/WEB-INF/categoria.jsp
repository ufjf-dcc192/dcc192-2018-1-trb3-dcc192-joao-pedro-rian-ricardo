<%@include file="jspf/cabecalho.jspf" %>

<title>Categoria</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <h4>Categoria ${categoria.categoria} e seus respectivos trabalhos:</h4><br/>
    </div>
    <div class="container-fluid" id="categorias">
        <table class="table">
            <thead>
                <tr class="text-center">
                    <th>Título do Trabalho</th>
                    <th>Descrição </th>
                    <th>Criador</th>
                    <th>Avaliação Final</th>
                    <th>Opções</th>
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
