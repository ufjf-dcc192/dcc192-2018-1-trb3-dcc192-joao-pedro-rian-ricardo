/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import DAOs.ComentarioDAO;
import DAOs.ItemDAO;
import DAOs.UsuarioDAO;
import Models.Comentario;
import Models.Item;
import Models.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class ComentarPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        String descricao = request.getParameter("descricao");
        Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
        UsuarioDAO dao = UsuarioDAO.getInstance();
        Usuario usuario = dao.getUsuarioById(idUsuario);
        Integer idItem = Integer.parseInt(request.getParameter("idItem"));
        ItemDAO daoItem = ItemDAO.getInstance();
        Item item = daoItem.getItemById(idItem);
        ComentarioDAO daoC = ComentarioDAO.getInstance();
        Comentario comentario = new Comentario(descricao, usuario, item);
        daoC.adicionarComentario(comentario);
        

    }

}
