
package Comandos;

import DAOs.ItemDAO;
import DAOs.UsuarioDAO;
import Models.Item;
import Models.Troll;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AvaliarCommand implements Comando {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
            List<Item> itens = ItemDAO.getInstance().aAvaliar(idUsuario);
            request.setAttribute("itens", itens);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/a-avaliar.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AvaliarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

