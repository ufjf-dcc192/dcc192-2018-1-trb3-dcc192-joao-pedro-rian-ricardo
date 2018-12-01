<%@include file="jspf/cabecalho.jspf" %>
<title>Comentários do Item</title>
</head>
<body>
    <br/>
    <h2 class="text-center text-dark"> ${item.titulo}</h2><br/>


    <div class="container">  

        <div class="row border border-primary p-3 mb-2 bg-primary text-white rounded">


            <div class="col-9"><h4>Descrição</h4><br/>${item.descricao}<br/></div>
            <div class="col-3">
                <h4>Autoria de ${item.usuario.nome}</h4><br/>
                Criação<br/>${item.getStringDataCriacao()}<br/> 
                Atualização<br/>${item.getStringDataAtu()}<br/>
                Avaliação Final: ${item.avaliacaofinal}<br/>
            </div>
        </div>
        <c:choose>
            <c:when test="${not empty item.comentarios}">

                <div class="row border p-3 mb-2 bg-light text-blue rounded" >

                    <c:forEach var="comentario" items="${item.comentarios}">

                        <div class="col-9 border"><i>Comentado em : ${comentario.getStringDataCriacao()} por : <b>${item.usuario.nome}</b></i><br/><br/>${comentario.comentario}</div>
                        <div class="col-3 border">
                        <br/>
                            <center><h5> Avaliação<br/>
                                    <b>${item.avaliacaofinal}</b></h5><br/></center>
                        </div>

                    </c:forEach>
                </div>

            </c:when>
            <c:otherwise>
                <h2 class="text-center text-success">Não há Comentários para o sistema!</h2>
            </c:otherwise>
        </c:choose>
    </div>


    <br/><br/>
    <%@include file="jspf/rodape.jspf" %>
