package Comandos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
       
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/registro.jsp");
        try {
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RegistroCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
