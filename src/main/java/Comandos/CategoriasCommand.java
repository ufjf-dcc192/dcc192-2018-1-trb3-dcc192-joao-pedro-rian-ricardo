package Comandos;

import DAOs.CategoriaDAO;
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

public class CategoriasCommand implements Comando {
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            if (request.getSession().getAttribute("acessoValido") != null && ((boolean)request.getSession().getAttribute("acessoValido")) == true) {
                request.setAttribute("categorias", CategoriaDAO.getInstance().getAllCategorias());
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/categorias.jsp");
                despachante.forward(request, response);
            } else {
                response.sendRedirect("sessionTags.html");
            }
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(CategoriasCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
