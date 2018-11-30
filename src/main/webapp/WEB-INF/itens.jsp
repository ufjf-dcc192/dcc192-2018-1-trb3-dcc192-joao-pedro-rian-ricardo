<%@include file="jspf/cabecalho.jspf" %>
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
        <table class="table table-striped table-responsive">
            <thead class="text-center">
                <tr>
                    <th>Título</th>
                    <th>Descrição</th>
                    <th>Data de criação</th>
                    <th>Data de atualização</th>
                    <th>Criador</th>
                    <th colspan="6">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${itens}">
                    <c:choose>
                        <c:when test="${item.usuario.id == sessionScope.usuarioID}">
                        <div class="row border border-light  p-3 mb-2 bg-light text-blue  rounded" >

                            <div class="col-9 border border-white"><h5>${item.titulo}</h5><br/><h6> ${item.descricao}</h6></div>
                            <div class="col-3 border border-white">
                                <h6>Criado por ${item.usuario.nome}
                                    <br/> 
                                    Avaliação<br/>
                                    ${item.avaliacaofinal}</h6><br/>
                                <a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                                <a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary" ><i class="fas fa-comment-dots"></i> Ver Comentários</a>
                                <a href="item-editar.html?idItem=${item.id}" class="btn btn-warning" ><i class="fas fa-edit"></i> Editar</a>
                                <a href="item-excluir.html?idItem=${item.id}" class="btn btn-danger" ><i class="fas fa-trash-alt"></i> Excluir</a>
                                <br/>
                            </div>

                        </div>

                        <br/>
                        <tr class="text-center">
                            <td>${item.titulo}</td>
                            <td>${item.descricao}</td>
                            <td>${item.getStringDataCriacao()}</td> 
                            <td>${item.getStringDataAtu()}</td>
                            <td>${item.usuario.nome}</td>
                            <td><a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                            <td><a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary" ><i class="fas fa-comment-dots"></i> Ver Comentários</a></td>
                            <td colspan="1"><a href="item-editar.html?idItem=${item.id}" class="btn btn-warning" ><i class="fas fa-edit"></i> Editar</a></td>
                            <td colspan="2"><a href="item-excluir.html?idItem=${item.id}" class="btn btn-danger" ><i class="fas fa-trash-alt"></i> Excluir</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="text-center">
                        <div class="row border border-light  p-3 mb-2 bg-light text-blue  rounded" >

                            <div class="col-9 border border-white"><h5>${item.titulo}</h5><br/><h6> ${item.descricao}</h6></div>
                            <div class="col-3 border border-white">
                                <h6>Criado por ${item.usuario.nome}
                                    <br/> 
                                    Avaliação<br/>
                                    ${item.avaliacaofinal}</h6><br/>
                                <a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                                <a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary" ><i class="fas fa-comment-dots"></i> Ver Comentários</a>
                                <a href="avaliarItem.html?idItem=${item.id}&aval=positiva" class="btn btn-success"><i class="far fa-thumbs-up"></i></a>
                                <a href="avaliarItem.html?idItem=${item.id}&aval=negativa" class="btn btn-danger"><i class="far fa-thumbs-down"></i></a>
                                <br/>
                            </div>

                        </div>
                        <td>${item.titulo}</td>
                        <td>${item.descricao}</td>
                        <td>${item.getStringDataCriacao()}</td> 
                        <td>${item.getStringDataAtu()}</td>
                        <td>${item.usuario.nome}</td>
                        <td><a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a></td>
                        <td><a href="itemComentarios.html?idItem=${item.id}" class="btn btn-primary" ><i class="fas fa-comment-dots"></i> Ver Comentários</a></td>
                        <c:choose>
                            <c:when test="${not item.comentado}">
                                <td><a href="comentar.html?idItem=${item.id}" class="btn btn-warning" ><i class="fas fa-edit"></i>Comentar</a></td>
                            </c:when>
                            <c:otherwise>
                                <td>Você já comentou este item</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${not item.avaliado}">
                                <td><a href="avaliarItem.html?idItem=${item.id}&aval=positiva" class="btn btn-success"><i class="far fa-thumbs-up"></i></a></td>
                                <td><a href="avaliarItem.html?idItem=${item.id}&aval=negativa" class="btn btn-danger"><i class="far fa-thumbs-down"></i></a></td>
                                    </c:when>
                                    <c:otherwise>
                                <td colspan="2">Você já avaliou este item</td>
                            </c:otherwise>
                        </c:choose>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            </tbody>
        </table>
    </div>

</body>
</html>
