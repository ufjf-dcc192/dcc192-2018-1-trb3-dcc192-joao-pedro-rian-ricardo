package Comandos;


import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {   
     
        try {
            Integer idParticipante;
            if(request.getAttribute("usuario")!=null){
                idParticipante = (Integer)request.getAttribute("usuario");
            } else{
                idParticipante = Integer.parseInt(request.getParameter("usuario"));
            }
            
            
            request.setAttribute("usuario", idParticipante);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
            despachante.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
