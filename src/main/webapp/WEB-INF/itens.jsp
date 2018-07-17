<%-- 
    Document   : ranking
    Created on : 16/07/2018, 01:20:46
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Lista de Itens</title>
</head>
<body>

    <h2 class="text-center text-success">Veja os itens cadastrados no sistema</h2>
    <br>
    <table class="table table-striped">
        <thead class="text-center">
            <tr>
                <th>Título</th>
                <th>Descrição</th>
                <th>Data de criação</th>
                <th>Data de atualização</th>
                <th>Criador</th>
                <th colspan="6">Opções</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${itens}">
                <c:choose>
                    <c:when test="${item.usuario.id == sessionScope.usuarioID}">
                        <tr class="text-center">
                            <td>${item.titulo}</td>
                            <td>${item.descricao}</td>
                            <td>${item.getStringDataCriacao()}</td> 
                            <td>${item.getStringDataAtu()}</td>
                            <td>${item.usuario.nome}</td>
                            <td><a>Ver Detalhes</a></td>
                            <td><a>Ver Comentários</a></td>
                            <td colspan="2"><a>Editar</a></td>
                            <td colspan="2"><a>Excluir</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="text-center">
                            <td>${item.titulo}</td>
                            <td>${item.descricao}</td>
                            <td>${item.getStringDataCriacao()}</td> 
                            <td>${item.getStringDataAtu()}</td>
                            <td>${item.usuario.nome}</td>
                            <td><a>Ver Detalhes</a></td>
                            <td><a>Ver Comentários</a></td>
                            <c:choose>
                                <c:when test="${not item.comentado}">
                                    <td><a>Comentar</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>Você já comentou este item</td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${not item.avaliado}">
                                    <td><a>Curtir</a></td>
                                    <td><a>Descurtir</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td colspan="2">Você já avaliou este item</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
