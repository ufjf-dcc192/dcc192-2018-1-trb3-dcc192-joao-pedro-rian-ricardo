<%-- 
    Document   : comentar
    Created on : 16/07/2018, 10:49:32
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Comentar</title>
</head>
<body>
    <c:if test="${enviado == 'true'}">
        <h4 class="text-success">Comentário realizado com sucesso!</h4>
    </c:if>
    <form class="form-group">
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Faça seu comentario:</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
        <button class="btn btn-primary" type="submit">Enviar</button>
    </form>
