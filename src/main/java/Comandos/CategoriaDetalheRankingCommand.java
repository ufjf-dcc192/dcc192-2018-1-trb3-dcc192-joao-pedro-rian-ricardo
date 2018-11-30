
package Comandos;

import DAOs.CategoriaDAO;
import DAOs.ItemDAO;
import Models.Categoria;
import Models.Item;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoriaDetalheRankingCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            Categoria categoria= CategoriaDAO.getInstance().getCategoriaAndItens(idCategoria);
            request.setAttribute("categoria", categoria);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/categoria.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(CategoriaDetalheRankingCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
