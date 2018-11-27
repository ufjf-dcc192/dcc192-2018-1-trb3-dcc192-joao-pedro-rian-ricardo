<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do Item</title>
</head>
<body>
    <h3 class="text-center text-danger">Veja todos os detalhes do item ${item.titulo} abaixo:</h3>
    <table class="table">
        <thead class="text-center">
            <tr>
                <th>Descrição</th>
                <th>Data de criação</th>
                <th>Data de atualização</th>
                <th>Criador</th>                
            </tr>
        </thead>
        <tbody>
                <tr class="text-center">
                    <td>${item.descricao}</td>
                    <td>${item.getStringDataCriacao()}</td> 
                    <td>${item.getStringDataAtu()}</td>
                    <td>${item.usuario.nome}</td>
                </tr>
                <tr>
                    <td colspan="4">Avaliação Final do Item: ${item.avaliacaofinal}</td>
                </tr>
        </tbody>
    </table>
    <c:choose>
        <c:when test="${not empty item.comentarios}">
            <h4 class="text-center text-success">Comentários feitos no item</h4>
            <table class="table table-striped">
                <thead class="text-center">
                    <tr>
                        <th>Comentário</th>
                        <th>Data do Comentário</th>
                        <th>Usuário que comentou</th>
                        <th>Avalição Final do Comentário</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="comentario" items="${item.comentarios}">
                        <tr class="text-center">
                            <td>${comentario.comentario}</td>
                            <td>${comentario.getStringDataCriacao()}</td>
                            <td>${comentario.usuario.nome}</td>
                            <td>${comentario.avaliacaofinal}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2 class="text-center text-success">Não há Comentários para o sistema!</h2>
        </c:otherwise>
    </c:choose>



    <%@include file="jspf/rodape.jspf" %>
