<%-- 
    Document   : meusComentarios
    Created on : 16/07/2018, 11:15:55
    Author     : Pedro
--%>

<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do usuario</title>
</head>
<body>
    <h6 class="text-center">Veja todos os comentários do usuário ${usuario.nome} abaixo:</h6>
    <table class="table table-striped">
        <thead>
        <th>Comentário</th>
        <th>Item</th>
    </thead>
    <tbody>
        <c:forEach var="comentario" items="${comentarios}">
        <tr>
            <td>${comentario.comentario}</td>
            <td>${comentario.item.titulo}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="jspf/rodape.jspf" %>