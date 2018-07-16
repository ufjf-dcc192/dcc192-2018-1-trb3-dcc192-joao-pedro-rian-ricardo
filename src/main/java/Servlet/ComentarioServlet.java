/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Comandos.Comando;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/comentar.html", "/item-comentarios.html", "/meus-comentarios.html", "/ranking.html"})
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/comentar.html", "Comandos.ComentarCommand");
            rotas.put("/item-comentarios.html", "Comandos.ItemComentariosCommand");
            rotas.put("/meus-comentarios.html", "Comandos.UsuarioComentariosCommand");
            rotas.put("/ranking.html", "Comandos.RankigCommand");

            String clazzName = rotas.get(request.getServletPath());

            Comando comando;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/comentar.html", "Comandos.ComentarCommand");
            String clazzName = rotas.get(request.getServletPath());

            Comando comando;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
