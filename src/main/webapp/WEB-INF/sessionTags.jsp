<%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Login - Tags</title>
    </head>
    <body>
        
        <div class="row">
            <div class="col"></div>
            <div class="col"></div>
            <div class="col"><br/>
                <div class="box-parent-login">
                    <div class="well bg-white box-login">


                        <img src="icones/login.png" class="rounded mx-auto d-block" width="500" height="166" alt="Imagem">
                        <br/>
                        <form method="post">
                            <fieldset>

                                <div class="form-group ls-login-password">
                                    <label for="userPassword">Senha</label>
                                    <input class="form-control ls-login-bg-password input-lg" id="userPassword" type="password" aria-label="Senha" placeholder="Senha" name="senha">
                                </div>

                                  <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block" name="acessar" >

                              
                            </fieldset>
                        </form>
                    </div>
                    <c:if test="${erroLogin == true}">
                        <div class="alert alert-danger" role="alert">
                            <center>Erro ao realizar Login! Verifique a senha!</center>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col"></div>
            <div class="col"></div>
        </div>

        <%@include file="/WEB-INF/jspf/rodape.jspf" %>