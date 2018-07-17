package Comandos;

import DAOs.ItemDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class ItemExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idItem = Integer.parseInt(request.getParameter("idItem"));
            ItemDAO.getInstance().excluirItem(idItem);
            request.setAttribute("excluido", true);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/itens.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ItemExcluirCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
