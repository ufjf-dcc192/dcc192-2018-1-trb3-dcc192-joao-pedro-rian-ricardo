package Comandos;

import DAOs.CategoriaDAO;
import DAOs.UsuarioDAO;
import Models.Categoria;
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

public class ItemNovoCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html;charset=UTF-8");
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
            UsuarioDAO dao = UsuarioDAO.getInstance();
            Usuario usuario = dao.getUsuarioById(idUsuario);
            List<Categoria> categorias = CategoriaDAO.getInstance().getAllCategorias();
            request.setAttribute("usuario", usuario);
            request.setAttribute("categorias", categorias);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoItem.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ItemNovoCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemNovoCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
