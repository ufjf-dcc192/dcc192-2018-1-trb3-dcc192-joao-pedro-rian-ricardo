package Servlet;

import Comandos.Comando;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ItemServlet", urlPatterns = {"/item-listar.html", "/item-novo.html", "/item-editar.html", "/item-excluir.html", "/item.html", "/a-avaliar.html"})
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/item-listar.html", "Comandos.ItensCommand");
            rotas.put("/item-novo.html", "Comandos.ItemNovoCommand");
            rotas.put("/item-editar.html", "Comandos.ItemEditarCommand");
            rotas.put("/item-excluir.html", "Comandos.ItemExcluirCommand");
            rotas.put("/item.html", "Comandos.ItemDetalhesCommand");
            rotas.put("/a-avaliar.html", "Comandos.AvaliarCommand");

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
            rotas.put("/item-novo.html", "Comandos.ItemNovoPostCommand");
            rotas.put("/item-editar.html", "Comandos.ItemEditarPostCommand");
            String clazzName = rotas.get(request.getServletPath());

            Comando comando = null;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
