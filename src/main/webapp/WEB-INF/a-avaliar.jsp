<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/cabecalho.jspf" %>


<title>Itens A Avaliar</title>
</head>

<body>

  
    <br/>
    <h3 class="text-center">Lista de Itens que você,${sessionScope.usuarioCompleto.nome}, ainda não Avaliou</h3>
    <br/>
    <table class="table table-hover">
        <thead>
            <tr class="text-center">
                <th>Usuário</th>
                <th>Total de Avaliações de Comentários</th>
                <th>Total de Avaliações Negativas</th>
                <th>Índice Percentual</th>
                
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty itens}">
                <h2 class="text-center text-success">Não há Itens a serem avaliados. Parabéns!</h2>
                </c:when>
                <c:otherwise>
                    <c:forEach var="troll" items="${trolls}">
                        <tr class="text-center">
                            <td>${troll.usuario.nome}</td> 
                            <td>${troll.totalAvaliacaoComentario}</td> 
                            <td class="text-danger">${troll.totalAvaliacaoNegativa}</td> 
                            <td class="text-danger">${troll.indiceTotal} %</td>                          
                        </tr>  
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </tbody>

    </table>

    <%@include file="/WEB-INF/jspf/rodape.jspf" %>