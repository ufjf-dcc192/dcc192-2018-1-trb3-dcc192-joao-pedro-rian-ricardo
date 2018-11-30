<%-- 
    Document   : ranking
    Created on : 16/07/2018, 01:20:46
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Ranking</title>
</head>
<body>
    <c:if test="${empty itens}">
        <div class="container-fluid">
            <form method="post">
                <h4>Escolha como deseja ordenar os itens:</h4>
                <div class="input-group">
                    <select class="custom-select" id="inputGroupSelect04" name="ordenacao">
                        <option selected>Escolha...</option>
                        <option value="2">Data de cria��o</option>
                        <option value="3">Data de atualiza��o</option>
                        <option value="5">N�mero de avalia��es</option>
                        <option value="4">Melhor avalia��o</option>
                    </select>
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="submit">Ordenar</button>
                    </div>
                </div>
            </form>
        </div>
    </c:if>
    <c:if test="${not empty itens}">
        <div  class="container-fluid">
            <form method="post">
                <h4>Escolha como deseja ordenar os itens:</h4>
                <div class="input-group">
                    <select class="custom-select" id="inputGroupSelect04" name="ordenacao">
                        <option selected>Escolha...</option>
                        <option value="2">Data de cria��o</option>
                        <option value="3">Data de atualiza��o</option>
                        <option value="5">N�mero de avalia��es</option>
                        <option value="4">Melhor avalia��o</option>
                    </select>
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="submit">Ordenar</button>
                    </div>
                </div>
            </form>
        </div>

        <table class="table table-striped">
            <thead class="text-center">
                <th>T�tulo</th>
                <th>Descri��o</th>
                <th>Data de cria��o</th>
                <th>Data de atualiza��o</th>
                <th>Criador</th>
                <th>Avalia��o Final</th>
            </thead>
        <tbody>
            <c:forEach var="item" items="${itens}">
                <tr class="text-center">
                    <td>${item.titulo}</td>
                    <td>${item.descricao}</td>
                    <td>${item.getStringDataCriacao()}</td> 
                    <td>${item.getStringDataAtu()}</td>
                    <td>${item.usuario.nome}</td>
                    <td>${item.avaliacaofinal}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>
