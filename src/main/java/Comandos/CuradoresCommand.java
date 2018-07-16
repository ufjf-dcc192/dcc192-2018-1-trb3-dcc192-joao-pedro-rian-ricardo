
package Comandos;

import DAOs.UsuarioDAO;
import Models.Curador;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CuradoresCommand implements Comando {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Curador> curadores = UsuarioDAO.getInstance().getCuradores();
            request.setAttribute("curadores", curadores);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/curadores.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CuradoresCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

