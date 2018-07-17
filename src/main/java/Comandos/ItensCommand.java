package Comandos;

import DAOs.ItemDAO;
import DAOs.UsuarioDAO;
import Models.Item;
import Models.Usuario;
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

public class ItensCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html;charset=UTF-8");
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
            List<Item> itens = ItemDAO.getInstance().getAllItens(idUsuario);
            request.setAttribute("itens", itens);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/itens.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ItensCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
