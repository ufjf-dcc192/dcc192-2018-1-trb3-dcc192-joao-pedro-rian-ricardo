
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


public class ItemDetalhesCommand implements Comando {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idItem = Integer.parseInt(request.getParameter("idItem"));
            Item item= ItemDAO.getInstance().getItemDetalhes(idItem);
            request.setAttribute("item", item);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/item.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ItemDetalhesCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

