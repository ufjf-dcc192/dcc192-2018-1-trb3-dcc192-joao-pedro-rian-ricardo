package Comandos;

import DAOs.CategoriaDAO;
import Models.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarCategoriaCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            Integer id = Integer.parseInt(request.getParameter("id"));
            CategoriaDAO dao = CategoriaDAO.getInstance();
            request.setAttribute("categoria", dao.getCategoriaById(id));
            response.sendRedirect("categorias.html?alterado=true");
        } catch (IOException ex) {
            Logger.getLogger(EditarCategoriaCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCategoriaCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
