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

@WebServlet(name = "PrincipalServlet", urlPatterns = {"/inicial.html", "/index.html", "/registro.html","/logout.html"})
public class PrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Map<String, String> rotas;
            rotas = new HashMap<>();
            rotas.put("/index.html", "Comandos.LoginCommand");
            rotas.put("/inicial.html", "Comandos.IndexCommand");
            rotas.put("/registro.html", "Comandos.RegistroCommand");
            rotas.put("/logout.html", "Comandos.SairCommand");

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
            rotas.put("/index.html", "Comandos.LoginPostCommand");
            rotas.put("/inicial.html", "Comandos.IndexCommand");
            rotas.put("/registro.html", "Comandos.RegistroPostCommand");
            
            String clazzName = rotas.get(request.getServletPath());
            
            Comando comando = null;
            
            comando = (Comando) Class.forName(clazzName).newInstance();
            
            comando.exec(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
