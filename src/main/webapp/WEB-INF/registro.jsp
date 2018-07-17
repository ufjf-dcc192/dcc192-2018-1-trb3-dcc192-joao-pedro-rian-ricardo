<%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
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
                    <input class="form-control" required="required" type="text" placeholder="Insira aqui o seu nome completo" name="nome"/><br/>
                </div>
                <div class="form-group">
                    <label>E-mail:</label>    
                    <input class="form-control" required="required" type="text" placeholder="Insira aqui o seu e-mail" name="email"/><br/>
                </div>
                <div class="form-group">
                    <label>Login:</label>    
                    <input class="form-control" required="required" type="text" placeholder="Insira aqui o seu login" name="login"/><br/>
                </div>
                <div class="form-group">
                    <label>Senha:</label>    
                    <input class="form-control" required="required" type="password" placeholder="Insira aqui a sua senha" name="senha"/><br/>
                </div>
                <input type="submit" class="btn btn-success"/>
                <input type="reset" class="btn btn-danger"/>
            </form>
        </div>
        <c:if test="${cadastro == true}">
            <h5 class="text-center alert-success"> Cadastro Realizado!</h5>
        </c:if>
            <a href="index.html" class="btn btn-primary" >Voltar</a>
        <div class="col"></div>
    </div>
    <%@include file="jspf/rodape.jspf" %>