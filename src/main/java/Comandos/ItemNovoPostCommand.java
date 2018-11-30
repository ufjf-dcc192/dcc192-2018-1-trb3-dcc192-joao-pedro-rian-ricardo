package Comandos;

import DAOs.ItemDAO;
import DAOs.UsuarioDAO;
import Models.Item;
import Models.Link;
import Models.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemNovoPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
           /* String[] values = request.getParameterValues("links");*/
            String[] categorias = request.getParameterValues("tags");
            /*List<Link> links = Link.StringToListLink(values);*/
            Item item = new Item();
            item.setTitulo(request.getParameter("titulo"));
            item.setDescricao(request.getParameter("descricao"));
            /*item.setLinks(links);*/
            item.setUsuario((Usuario)request.getSession().getAttribute("usuarioCompleto"));
            ItemDAO.getInstance().adicionarItem(item,categorias);
            response.sendRedirect("item-listar.html?cadastrado=true");
        } catch (IOException ex) {
            Logger.getLogger(ItemNovoPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
