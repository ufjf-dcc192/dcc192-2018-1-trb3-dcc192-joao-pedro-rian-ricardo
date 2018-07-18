package Comandos;

import DAOs.ItemDAO;
import Models.Item;
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
public class ItemEditarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idItem = Integer.parseInt(request.getParameter("idItem"));
            Item item= ItemDAO.getInstance().getItemById(idItem);
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("item", item);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/editarItem.jsp");
            despachante.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ItemExcluirCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ItemEditarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
