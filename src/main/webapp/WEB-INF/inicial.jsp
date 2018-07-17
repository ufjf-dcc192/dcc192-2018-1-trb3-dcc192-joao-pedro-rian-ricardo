<%@include file="jspf/cabecalho.jspf" %>

<title>Página Inicial</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col col-lg-3">                
                ${usuario.login}<br/>
                ${usuario.email}<br/>     
            </div>
            <div class="col col-lg-6">
                <h4>Bem-Vindo ${usuario.nome}<br/></h4>
                <a href="item-novo.html"><button type="button" class="btn btn-primary">Criar Item de Discussão</button></a>
                <br/>
                <br/>
            </div>
        </div>
                <img src="icones/curadoria.png" width="800" height="315">
    </div>
    <br/>
    <br/>



    <br/>
    <%@include file="jspf/rodape.jspf" %>
