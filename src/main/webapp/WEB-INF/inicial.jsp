<%@include file="jspf/cabecalho.jspf" %>

<title>Página Inicial</title>
</head>
<body>
    <br/>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <center><h3>Bem-Vindo,<br/>${usuario.nome}<br/></h3></center>
                <center><a href="item-novo.html" class="btn btn-success"><i class="fas fa-plus-circle"></i> Novo Trabalho</a></center>
                <br/>
                <br/>
            </div>
            <div class="col"> 

                <br/>
                <br/>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <div class="container-fluid">
                    <center><h5>Escolha uma categoria para acessar os trabalhos cadastrados</h5></center><br/>
                </div>
                <div class="container-fluid" id="categorias">
                    <div class="col"></div>
                    <div class="col">
                        <c:forEach var="categoria" items="${categorias}">
                            <a href="categoria-ranking.html?idCategoria = ${categoria.id}" class="btn btn-primary btn-lg btn-block">${categoria.categoria}</a>

                        </c:forEach>
                    </div>>

                    <div class="col"></div>

                </div>
                <br/>
            </div>
            <div class="col"> 

                <br/>
                <br/>
            </div>
        </div>
    </div>
                
  <!-- Para aproveitar na categoria   <div class="container-fluid">
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

    <br/>
    <br/>
    <br/>-->
    <%@include file="jspf/rodape.jspf" %>
