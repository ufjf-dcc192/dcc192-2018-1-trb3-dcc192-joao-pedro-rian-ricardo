package Comandos;

import DAOs.CategoriaDAO;
import DAOs.UsuarioDAO;
import Models.Categoria;
import Models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroCategoriaPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            String descricao = request.getParameter("categoria");
            request.setAttribute("cadastro", true);
            CategoriaDAO dao = CategoriaDAO.getInstance();
            Categoria categoria = new Categoria().setCategoria(descricao);
            dao.adicionar(categoria);
            response.sendRedirect("categorias.html?cadastro=true");
        } catch (IOException ex) {
            Logger.getLogger(RegistroCategoriaPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroCategoriaPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
