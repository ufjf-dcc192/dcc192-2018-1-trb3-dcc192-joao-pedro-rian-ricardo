package Comandos;

import DAOs.CategoriaDAO;
import DAOs.ConfiguracaoDAO;
import DAOs.UsuarioDAO;
import Models.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTagsPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String senha = request.getParameter("senha");
            String senhaArmazenada = ConfiguracaoDAO.getInstance().getConfiguracoes().get("senha");
            if (senha.equals(senhaArmazenada)) {
                request.setAttribute("categorias", CategoriaDAO.getInstance().getAllCategorias());
                request.getSession().setAttribute("acessoValido", true);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/categorias.jsp");
                despachante.forward(request, response);
            } else {
                request.setAttribute("erroLogin", true);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/sessionTags.jsp");

                despachante.forward(request, response);
            }
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(SessionTagsPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
