package Servlet;

import Comandos.Comando;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PrincipalServlet", urlPatterns = {"/index.html", "/login.html", "/registro.html"})
public class PrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Map<String, String> rotas;
            rotas = new HashMap<String, String>();
            rotas.put("/index.html", "Comandos.LoginCommand");
            rotas.put("/inicial.html", "Comandos.IndexCommand");
            rotas.put("/registro.html", "Comandos.RegistroCommand");

            String clazzName = rotas.get(request.getServletPath());

            Comando comando;

            comando = (Comando) Class.forName(clazzName).newInstance();

            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Map<String, String> rotas;
            rotas = new HashMap<String, String>();
            rotas.put("/index.html", "Comandos.LoginPostCommand");
            rotas.put("/inscricao.html", "Comandos.InscricaoPostCommand");
            rotas.put("/registro.html", "Comandos.RegistroPostCommand");
            
            String clazzName = rotas.get(request.getServletPath());
            
            Comando comando = null;
            
            comando = (Comando) Class.forName(clazzName).newInstance();
            
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
