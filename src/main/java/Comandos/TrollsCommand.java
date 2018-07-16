
package Comandos;

import DAOs.UsuarioDAO;
import Models.Troll;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TrollsCommand implements Comando {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Troll> trolls = UsuarioDAO.getInstance().getTrolls();
            request.setAttribute("trolls", trolls);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/trolls.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TrollsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

