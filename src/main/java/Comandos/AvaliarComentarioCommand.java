package Comandos;

import DAOs.ComentarioDAO;
import DAOs.ItemDAO;
import Models.AvaliacaoComentario;
import Models.AvaliacaoItem;
import Models.Comentario;
import Models.Item;
import Models.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AvaliarComentarioCommand implements Comando {

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
            Integer idComent = Integer.parseInt(request.getParameter("idComentario"));
            Comentario comentario = ComentarioDAO.getInstance().getComentarioById(idComent);
            AvaliacaoComentario av = new AvaliacaoComentario(positiva, negativa, usuario, comentario);
            ComentarioDAO.getInstance().adicionarAvaliacao(av);
            int id = Integer.parseInt(request.getParameter("idItem"));
            response.sendRedirect("itemComentarios.html?idItem="+id);
        } catch (IOException ex) {
            Logger.getLogger(AvaliarItemCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}