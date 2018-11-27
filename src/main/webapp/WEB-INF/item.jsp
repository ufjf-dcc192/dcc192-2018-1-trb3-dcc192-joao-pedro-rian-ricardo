<%@include file="jspf/cabecalho.jspf" %>
<title>Coment�rios do Item</title>
</head>
<body>
    <h2 class="text-center text-danger"> Detalhes do trabalho</h2><br/>
    <h3 class="text-center text-danger">${item.titulo}</h3><br/>
    
    <div class="row">
  <div class="col-9"><h3 class="text-center text-danger">${item.titulo}</h3><br/></div>
  <div class="col-4"><h4>Descri��o</h4><br/>${item.descricao}<br/></div>
  <div class="col-6">
      <h4>${item.usuario.nome}</h4><br/>
      Data de cria��o : ${item.getStringDataCriacao()}<br/> 
      Data de atualiza��o:${item.getStringDataAtu()}<br/>
      ${item.avaliacaofinal}<br/>
  </div>
</div>
    <table class="table table-striped">
        <thead class="text-center">
            <tr>
                <th>Descri��o</th>
                <th>Data de cria��o</th>
                <th>Data de atualiza��o</th>
                <th>Criador</th>
                <th>Avalia��o Final do Item</th>
            </tr>
        </thead>
        <tbody>
                <tr class="text-center">
                    <td>${item.descricao}</td>
                    <td>${item.getStringDataCriacao()}</td> 
                    <td>${item.getStringDataAtu()}</td>
                    <td>${item.usuario.nome}</td>
                    <td>${item.avaliacaofinal}</td>
                </tr>
        </tbody>
    </table>
    <c:choose>
        <c:when test="${not empty item.comentarios}">
            <h4 class="text-center text-success">Coment�rios feitos no item</h4>
            <table class="table table-striped">
                <thead class="text-center">
                    <tr>
                        <th>Coment�rio</th>
                        <th>Data do Coment�rio</th>
                        <th>Usu�rio que comentou</th>
                        <th>Avali��o Final do Coment�rio</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="comentario" items="${item.comentarios}">
                        <tr class="text-center">
                            <td>${comentario.comentario}</td>
                            <td>${comentario.getStringDataCriacao()}</td>
                            <td>${comentario.usuario.nome}</td>
                            <td>${comentario.avaliacaofinal}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2 class="text-center text-success">N�o h� Coment�rios para o sistema!</h2>
        </c:otherwise>
    </c:choose>



    <%@include file="jspf/rodape.jspf" %>
