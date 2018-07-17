<%-- 
    Document   : itemComentarios
    Created on : 16/07/2018, 11:06:23
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do Item</title>
</head>
<body>
    <h6 class="text-center">Veja todos os comentários do item ${item.titulo} abaixo:</h6>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Comentários</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comentario" items="${comentarios}">
                <tr>
                    <td>${comentario.comentario}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@include file="jspf/rodape.jspf" %>