<%@include file="jspf/cabecalho.jspf" %>

<title>Página Inicial</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col col-lg-12">
                <h4>Bem-Vindo, ${usuario.nome}<br/></h4>
                <a href="item-novo.html" class="btn btn-success"><i class="fas fa-plus-circle"></i> Criar Trabalho</a>
                <br/>
                <br/>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <h4>Veja as categorias e seus respectivos trabalhos:</h4><br/>
    </div>
        <div class="container-fluid" id="categorias">

            <c:forEach var="categoria" items="${categorias}">
                <table class="table">
                    <thead>
                        <tr>
                            <th colspan="4" class="text-center"><h3>${categoria.categoria}</h3></th>
                        </tr>
                        <tr class="text-center">
                            <th>Título do Jogo</th>
                            <th>Descrição </th>
                            <th>Criador</th>
                            <th>Avaliação Final</th>
                            <th>Opções</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:choose>
                            <c:when test="${not empty categoria.itens}">
                                <c:forEach var="item" items="${categoria.itens}">
                                    <tr class="text-center">
                                        <td>${item.titulo}</td>
                                        <td>${item.descricao}</td>
                                        <td>${item.usuario.nome}</td>
                                        <td>${item.avaliacaofinal}</td>
                                        <td><a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </c:forEach>




        </div>
    </div>
    <br/>
    <br/>
    <br/>
    <%@include file="jspf/rodape.jspf" %>
