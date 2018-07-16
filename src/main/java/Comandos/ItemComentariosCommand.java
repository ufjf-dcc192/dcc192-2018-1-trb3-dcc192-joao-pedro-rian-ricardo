package Comandos;

import DAOs.ComentarioDAO;
import DAOs.ItemDAO;
import Models.Comentario;
import Models.Item;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemComentariosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idItem = Integer.parseInt(request.getParameter("item"));
            ItemDAO dao = ItemDAO.getInstance();
            Item item = dao.getItemById(idItem);
            List<Comentario> comentarios = ComentarioDAO.getInstance().getComentariobyItem(item);
            
            request.setAttribute("comentarios", comentarios);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/itemComentarios.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ItemComentariosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
