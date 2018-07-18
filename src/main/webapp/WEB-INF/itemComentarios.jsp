<%-- 
    Document   : itemComentarios
    Created on : 16/07/2018, 11:06:23
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do Item</title>
</head>
<body>
    <h4 class="text-center">Veja todos os comentários do item ${item.titulo} abaixo:</h4>
    <table class="table table-striped">
        <thead>
            <tr class="text-center">
                <th>Comentários</th>
                <th colspan="2">Opções</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comentario" items="${comentarios}">
                <tr class="text-center">
                    <td>${comentario.comentario}</td>
                    <c:choose>
                        <c:when test="${not comentario.avaliado}">
                            <td><a href="avaliarComentario.html?idComentario=${comentario.id}&idItem=${item.id}&aval=positiva" class="btn btn-success"><i class="far fa-thumbs-up"></i> Curtir</a></td>
                            <td><a href="avaliarComentario.html?idComentario=${comentario.id}&idItem=${item.id}&aval=negativa" class="btn btn-danger"><i class="far fa-thumbs-down"></i> Descurtir</a></td>
                        </c:when>
                        <c:otherwise>
                            <td colspan="2">Você já avaliou este comentário</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@include file="jspf/rodape.jspf" %>