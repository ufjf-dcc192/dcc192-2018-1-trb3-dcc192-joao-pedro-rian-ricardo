<%@include file="jspf/cabecalho.jspf" %>
<script type="text/javascript">
    var categorias = <%=request.getAttribute("categorias")%>;
</script>
<title>Página Inicial</title>
</head>
<body>
    <br/>
    <div class="container-fluid">
        <div class="row">
            <div class="col col-lg-3">     
            </div>
            <div class="col col-lg-6">
                <h4>Bem-Vindo, ${usuario.nome}<br/></h4>
                <a href="item-novo.html" class="btn btn-primary">Criar Item</a>
                <br/>
                <br/>
            </div>
        </div>

        <div class="row container-fluid" id="categorias">
            <h4>Veja as categorias e seus respectivos itens:</h4><br/>
            

        </div>
    </div>
    <br/>
    <br/>
    <br/>
    <script type="text/javascript" src="js/Cards.js">
    </script>
    <%@include file="jspf/rodape.jspf" %>
