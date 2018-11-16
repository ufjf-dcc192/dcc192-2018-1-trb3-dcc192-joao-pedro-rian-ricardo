<%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Criação de uma Categoria (#HashTags)</title>
    </head>
    <body>
    <center><h3>Cadastre abaixo a HashTag, preencha todos os dados</h3></center>
    <div class="row">
        <div class="col"></div>
        <div class="col"><br/>

            <form method="post">
                <div class="form-group">
                    <label>Categoria:</label>
                    <input class="form-control" required="required" type="text" placeholder="Insira aqui a hashtag" name="hashtag"/><br/>
                </div>
                <input type="submit" class="btn btn-success"/>
                <input type="reset" class="btn btn-danger"/>
            </form>
        </div>
        <div class="col"></div>
    </div>
    <br/>
    <br/>
    <%@include file="jspf/rodape.jspf" %>