package Comandos;

import DAOs.ItemDAO;
import Models.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class RankingCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Item> itens = new ArrayList<>();
            request.setAttribute("itens", itens);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ranking.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RankingCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
