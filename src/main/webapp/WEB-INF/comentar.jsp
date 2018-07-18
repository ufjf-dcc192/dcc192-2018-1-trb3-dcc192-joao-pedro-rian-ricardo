<%-- 
    Document   : comentar
    Created on : 16/07/2018, 10:49:32
    Author     : Pedro
--%>
<%@include file="jspf/cabecalho.jspf" %>
<title>Comentar</title>
</head>
<body>
<br/>
        <br/>
    <div class="container-fluid">
        <form class="form-group" method="post">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Faça seu comentario:</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descricao"></textarea>
                <input type="hidden" value="${idItem}" name="idItem"/>
            </div>
            <button class="btn btn-primary" type="submit">Enviar</button>
        </form>
    </div>
    <%@include file="jspf/rodape.jspf" %>