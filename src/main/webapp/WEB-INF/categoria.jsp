<%@include file="jspf/cabecalho.jspf" %>

<title>Categoria</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <center><h4>Categoria ${categoria.categoria} e seus respectivos trabalhos</h4></center><br/>
    </div>
    
    <div class="container-fluid" id="categorias">
        <div class="row">
            <div class="col"></div>
            <div class="col-7">
                <c:choose>
                    <c:when test="${not empty categoria.itens}">
                    <div class="row border border-light  p-3 mb-2 bg-light text-blue  rounded" >
                        <c:forEach var="item" items="${categoria.itens}">

                            <div class="col-9 border border-white"><h5>${item.titulo}</h5><br/><h6> ${item.descricao}</h6></div>
                            <div class="col-3 border border-white">
                                    <h6>Criado por ${item.usuario.nome}
                                    <br/> 
                                    Avaliação<br/>
                                    ${item.avaliacaofinal}</h6><br/>
                                <a href="item.html?idItem=${item.id}" class="btn btn-primary"><i class="fas fa-info-circle"></i> Ver Detalhes</a>
                                <br/>
                            </div>


                        </div>
                        <br/>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
           
   </div>
            <div class="col"> 

                <br/>
                <br/>
            </div>
        </div>
    </div>
    <br/><br/>
    <br/><br/>
    <%@include file="jspf/rodape.jspf" %>
