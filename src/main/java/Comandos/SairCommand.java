
package Comandos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SairCommand implements Comando {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().invalidate();
            response.sendRedirect("index.html");
        } catch (IOException ex) {
            Logger.getLogger(SairCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

