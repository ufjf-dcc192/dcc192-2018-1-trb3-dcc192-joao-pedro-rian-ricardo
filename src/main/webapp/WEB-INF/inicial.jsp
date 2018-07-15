<%@include file="jspf/cabecalho.jspf" %>

<title>Página Inicial</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col col-lg-3">                

                <h5>${usuario.login}<br/></h5>
                ${usuario.nome}<br/>
                ${usuario.email}<br/>     


            </div>
            <div class="col col-lg-6">
                <a href=""><button type="button" class="btn btn-primary">Criar Item de Discussão</button></a>
                <br/>
                <br/>


            </div>

        </div>
    </div>
    <br/>
    <br/>



    <br/>
    <%@include file="jspf/rodape.jspf" %>
