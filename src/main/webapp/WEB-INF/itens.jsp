<%@include file="jspf/cabecalho.jspf"%>
<title>Lista de Itens</title>
</head>
<body>
    <c:if test="${excluido == true}">
        <div class="alert alert-success" role="alert">
            <h4 class="text-center text-success"> Item excluído com sucesso</h4>
        </div>
    </c:if>
    <c:if test="${comentado == true}">
        <div class="alert alert-success" role="alert">
            <h4 class="text-center alert-success">Comentário realizado com sucesso</h4>
        </div>
    </c:if>

    <c:if test="${cadastrado == true}">
        <div class="alert alert-success" role="alert">
            <h4 class="text-center alert-success">Item cadastrado com sucesso</h4>
        </div>
    </c:if>
    <h2 class="text-center text-success">Veja os itens cadastrados no sistema</h2>
    <br>
    <div class="container-fluid">
        <c:forEach var="item" items="${itens}">
            <c:choose>
                <c:when test="${item.usuario.id == sessionScope.usuarioID}">
                    <div class="row border border-light  p-3 mb-2 bg-light text-blue  rounded" >

                        <div class="col-9 border border-white"><h5>${item.titulo}</h5><br/><h6> ${item.descricao}</h6></div>
                        <div class="col-3 border border-white">
                            <div class="container-fluid">
                                <h6>Criado por ${item.usuario.nome} </h6>
                                <a href="item.html?idItem=${item.id}" class="btn btn-primary btn-block"><i class="fas fa-info-circle"></i> Ver Detalhes</a>
                            </div>
                            <div class="container-fluid">
                                <a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary btn-block" ><i class="fas fa-comment-dots"></i> Ver Comentários</a>
                            </div>
                            <div class="container-fluid">
                                <a href="item-editar.html?idItem=${item.id}" class="btn btn-warning btn-block" ><i class="fas fa-edit"></i> Editar</a>
                            </div>
                            <div class="container-fluid">
                                <a href="item-excluir.html?idItem=${item.id}" class="btn btn-danger btn-block" ><i class="fas fa-trash-alt"></i> Excluir</a>
                                <br/>
                            </div>
                        </div>

                    </div>

                    <br/>
                </c:when>
                <c:otherwise>
                    <div class="row border border-light  p-3 mb-2 bg-light text-blue  rounded" >

                        <div class="col-9 border border-white">
                            <h5>${item.titulo}</h5>
                            <br/>
                            <h6> ${item.descricao}</h6>
                        </div>
                        <div class="col-3 border border-white">
                            <div class="container-fluid btn-block">
                                <h6>Criado por ${item.usuario.nome}</h6>
                                <a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a>
                            </div>
                            <div class="container-fluid btn-block">
                                <a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary" ><i class="fas fa-comment-dots"></i> Ver Comentários</a>
                            </div>
                            <c:choose>
                                <c:when test="${not item.comentado}">
                                    <div class="container-fluid btn-block">
                                        <a href="comentar.html?idItem=${item.id}" class="btn btn-warning" ><i class="fas fa-edit"></i>Comentar</a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="container-fluid btn-block">
                                        Você já comentou este item
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${not item.avaliado}">
                                    <div class="container-fluid btn-block ">
                                        <div class="btn-group">
                                            <a href="avaliarItem.html?idItem=${item.id}&aval=positiva" class="btn btn-success"><i class="far fa-thumbs-up"></i></a>
                                            <a href="avaliarItem.html?idItem=${item.id}&aval=negativa" class="btn btn-danger"><i class="far fa-thumbs-down"></i></a>
                                        </div>   
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="container-fluid btn-block ">
                                        Você já avaliou este item
                                    </div>
                                </c:otherwise>

                            </c:choose>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>

</body>
</html>
