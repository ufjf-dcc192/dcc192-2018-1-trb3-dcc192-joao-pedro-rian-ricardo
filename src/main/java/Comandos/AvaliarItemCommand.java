package Comandos;

import DAOs.ItemDAO;
import Models.AvaliacaoItem;
import Models.Item;
import Models.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AvaliarItemCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer positiva;
            Integer negativa;
            if ("positiva".equals(request.getParameter("aval"))) {
                positiva = 1;
                negativa = 0;
            } else {
                positiva = 0;
                negativa = 1;
            }
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioCompleto");
            Integer idItem = Integer.parseInt(request.getParameter("idItem"));
            Item item = ItemDAO.getInstance().getItemById(idItem);
            AvaliacaoItem av = new AvaliacaoItem(positiva, negativa, usuario, item);
            ItemDAO.getInstance().adicionarAvaliacao(av);
            response.sendRedirect("item-listar.html");
        } catch (IOException ex) {
            Logger.getLogger(AvaliarItemCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
