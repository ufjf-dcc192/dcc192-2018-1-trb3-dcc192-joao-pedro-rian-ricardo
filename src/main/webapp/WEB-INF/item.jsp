<%@include file="jspf/cabecalho.jspf" %>
<title>Coment�rios do Item</title>
</head>
<body>
    <h2 class="text-center text-danger"> ${item.titulo}</h2><br/>


 <div class="container">  
     
     <div class="row border border-bg-info p-3 mb-2 bg-info text-white rounded">
         
        
        <div class="col-9"><h4>Descri��o</h4><br/>${item.descricao}<br/></div>
        <div class="col-3">
            <h4>Autoria de ${item.usuario.nome}</h4><br/>
            Cria��o<br/>${item.getStringDataCriacao()}<br/> 
            Atualiza��o<br/>${item.getStringDataAtu()}<br/>
            ${item.avaliacaofinal}<br/>
        </div>
       </div>
    <c:choose>
        <c:when test="${not empty item.comentarios}">
            <h4 class="text-center text-success">Coment�rios</h4>

            <div class="row border p-3 mb-2 bg-light text-blue rounded" >
                <c:forEach var="comentario" items="${item.comentarios}">

                    <div class="col-9 border"><i>Data de Cria��o : ${comentario.getStringDataCriacao()}</i><br/>${comentario.comentario}</div>
                    <div class="col-3 border">
                        <br/>
                        <h5>${item.usuario.nome}</h5><br/>
                        <br/> 
                        Avalia��o<br/>
                        ${item.avaliacaofinal}<br/>
                    </div>

                </c:forEach>
            </div>

        </c:when>
        <c:otherwise>
            <h2 class="text-center text-success">N�o h� Coment�rios para o sistema!</h2>
        </c:otherwise>
    </c:choose>
 </div>



    <%@include file="jspf/rodape.jspf" %>
