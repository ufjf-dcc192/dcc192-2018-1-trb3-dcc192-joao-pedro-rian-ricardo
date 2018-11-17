package Comandos;

import DAOs.CategoriaDAO;
import Models.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarCategoriaCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
             if (request.getSession().getAttribute("acessoValido") != null && ((boolean) request.getSession().getAttribute("acessoValido")) == true) {
            request.setCharacterEncoding("UTF-8");
            Integer id = Integer.parseInt(request.getParameter("idCategoria"));
            CategoriaDAO dao = CategoriaDAO.getInstance();
            request.setAttribute("categoria", dao.getCategoriaById(id));
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/editarCategoria.jsp");
            despachante.forward(request, response);
             }else {
                response.sendRedirect("sessionTags.html");
            }
        } catch (IOException ex) {
            Logger.getLogger(EditarCategoriaCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCategoriaCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarCategoriaCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
