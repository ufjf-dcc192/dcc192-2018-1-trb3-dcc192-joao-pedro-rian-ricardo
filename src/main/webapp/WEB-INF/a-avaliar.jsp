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
                <th>Nome do Item</th>
                <th>Descrição do Item</th>
                <th>Data de Criação</th>
                <th>Data de Atualização</th>
                <th>Criador</th>
                
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty itens}">
                <h2 class="text-center text-success">Não há Itens a serem avaliados. Parabéns!</h2>
                </c:when>
                <c:otherwise>
                    <c:forEach var="item" items="${itens}">
                        <tr class="text-center">
                            <td>${item.titulo}</td> 
                            <td>${item.descricao}</td> 
                            <td>${item.getStringDataCriacao()}</td> 
                            <td>${item.getStringDataAtu()}</td>                          
                            <td>${item.usuario.nome}</td>
                        </tr>  
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </tbody>

    </table>

    <%@include file="/WEB-INF/jspf/rodape.jspf" %>