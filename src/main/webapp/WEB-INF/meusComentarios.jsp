<%-- 
    Document   : meusComentarios
    Created on : 16/07/2018, 11:15:55
    Author     : Pedro
--%>

<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do usuario</title>
</head>
<body>
    <c:if test="${excluido == true}">
        <h4 class="text-center text-success">Comentário excluído com sucesso</h4>
    </c:if>
    <h6 class="text-center">Veja todos os comentários do usuário ${usuario.nome} abaixo:</h6>
    <table class="table table-striped">
        <thead class="text-center">
        <th>Comentário</th>
        <th>Item</th>
        <th>Opções</th>
    </thead>
    <tbody class="text-center">
        <c:forEach var="comentario" items="${comentarios}">
            <tr>
                <td>${comentario.comentario}</td>
                <td>${comentario.item.titulo}</td>
                <td><a href="excluirComentario.html?idComent=${comentario.id}" class="btn btn-danger">Excluir</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="jspf/rodape.jspf" %>