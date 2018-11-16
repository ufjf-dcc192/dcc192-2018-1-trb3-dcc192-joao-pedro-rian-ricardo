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
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/categorias.html", "/editarCategoria.html", "/novaCategoria.html", "/sessionHashtags.html"})
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/categorias.html", "Comandos.CategoriasCommand");
            rotas.put("/editarCategoria.html", "Comandos.EditarCategoriaCommand");
            rotas.put("/novaCategoria.html", "Comandos.RegistroCategoriaCommand");
            rotas.put("/sessionHashtags.html", "Comandos.SessionHashtagCommand");

            String clazzName = rotas.get(request.getServletPath());

            Comando comando;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/novaCategoria.html", "Comandos.RegistroCategoriaPostCommand");
            rotas.put("/editarCategoria.html", "Comandos.EditarCategoriaPostCommand");
            rotas.put("/sessionHashtags.html", "Comandos.SessionHashtagPostCommand");
            String clazzName = rotas.get(request.getServletPath());

            Comando comando;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
