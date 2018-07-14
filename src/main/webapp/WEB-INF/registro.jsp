<%-- 
    Document   : inscricao
    Created on : 01/07/2018, 10:57:29
    Author     : Rian Alves
--%>

<%@include file="jspf/cabecalho.jspf" %>
<title>Criação de um Usuário</title>
    </head>
    <body>
    <center><h3>Cadastre abaixo o seu usuário, preencha todos os dados</h3></center>
        <div class="row">
            <div class="col"></div>
            <div class="col"><br/>
               
                <form method="post">
                    <div class="form-group">
                    <label>Nome Completo:</label>
                        <input class="form-control" type="text" placeholder="Insira aqui o seu nome completo" name="nome"/><br/>
                    </div>
                    <div class="form-group">
                    <label>E-mail:</label>    
                        <input class="form-control" type="text" placeholder="Insira aqui o seu e-mail" name="email"/><br/>
                    </div>
                     <div class="form-group">
                    <label>Login:</label>    
                        <input class="form-control" type="text" placeholder="Insira aqui o seu login" name="email"/><br/>
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>    
                        <input class="form-control" type="password" placeholder="Insira aqui a sua senha" name="senha"/><br/>
                    </div>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-danger"/>
                </form>
            </div>
            <div class="col"></div>
        </div>
<%@include file="jspf/rodape.jspf" %>