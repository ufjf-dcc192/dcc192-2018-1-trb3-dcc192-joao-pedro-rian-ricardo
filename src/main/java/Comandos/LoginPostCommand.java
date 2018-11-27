package Comandos;

import DAOs.CategoriaDAO;
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

public class LoginPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            UsuarioDAO dao = UsuarioDAO.getInstance();
            Usuario usuario = dao.getUsuario(user, senha);
            if (usuario == null) {
                request.setAttribute("erroLogin", true);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/login.jsp");
                despachante.forward(request, response);

            } else {
               
                request.getSession().setAttribute("usuarioID", usuario.getId());
                request.getSession().setAttribute("usuarioCompleto", usuario);
                request.setAttribute("categorias", CategoriaDAO.getInstance().getAllCategoriaAndItens());
                IndexCommand comando = new IndexCommand();
                comando.exec(request, response);
            }
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(LoginPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
