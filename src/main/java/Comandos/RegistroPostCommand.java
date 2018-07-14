package Comandos;

import DAOs.UsuarioDAO;
import Models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroPostCommand implements Comando {

     @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        UsuarioDAO dao = UsuarioDAO.getInstance();
        Usuario usuario = new Usuario(nome,login, email, senha);     
        dao.adicionar(usuario);
        response.sendRedirect("login.html");
       
    }
    
}
