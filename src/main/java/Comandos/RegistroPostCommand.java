package Comandos;

import DAOs.UsuarioDAO;
import Models.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroPostCommand implements Comando {

     @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        request.setAttribute("cadastro", true);
        UsuarioDAO dao = UsuarioDAO.getInstance();
        Usuario usuario = new Usuario(nome,login, email, senha);     
        dao.adicionar(usuario);
         try {
             response.sendRedirect("index.html");
         } catch (IOException ex) {
             Logger.getLogger(RegistroPostCommand.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    
}
