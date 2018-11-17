<%@include file="jspf/cabecalhoCategoria.jspf" %>
<title>Lista de Tags</title>
</head>
<body>
    <c:if test="${alterado == true}">
        <div class="alert alert-success" role="alert">
            <h4 class="text-center alert-success">Alteração realizada com sucesso</h4>
        </div>
    </c:if>

    <c:if test="${cadastrado == true}">
        <div class="alert alert-success" role="alert">
            <h4 class="text-center alert-success">Hashtag cadastrada com sucesso</h4>
        </div>
    </c:if>
    <h2 class="text-center text-success">Veja as hashtags cadastradas no sistema</h2>
    <br>
    <div class="container-fluid">
        <table class="table table-striped">
            <thead class="text-center">
                <tr>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="categoria" items="${categorias}">

                    <tr class="text-center">
                        <td>${categoria.id}</td>
                        <td>${categoria.categoria}</td>
                        <td><a href="editarCategoria.html?idCategoria=${categoria.id}" class="btn btn-primary"><i class="fas fa-pen"></i> Editar</a></td>
                    </tr>
                    </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
