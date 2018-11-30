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
                <th>Coment�rios</th>
                <th colspan="2">Op��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comentario" items="${comentarios}">
			 <c:choose>
                    <c:when test="${comentario.usuario.id == sessionScope.usuarioID}">
                        <tr class="text-center">
                            <td>${comentario.comentario}</td>
                            <td colspan="2"><a href="excluirComentario.html?idComent=${comentario.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Excluir</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
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
				</c:otherwise>
				</c:choose>
            </c:forEach>
        </tbody>
    </table>
    <%@include file="jspf/rodape.jspf" %>
