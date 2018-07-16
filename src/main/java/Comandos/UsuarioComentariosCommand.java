/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import DAOs.ComentarioDAO;
import DAOs.UsuarioDAO;
import Models.Comentario;
import Models.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class UsuarioComentariosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
            List<Comentario> comentarios = ComentarioDAO.getInstance().getComentariosByUsuario(idUsuario);
            Usuario usuario = UsuarioDAO.getInstance().getUsuarioById(idUsuario);
            request.setAttribute("usuario", usuario);
            request.setAttribute("comentarios", comentarios);
            
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/meusComentarios.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UsuarioComentariosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
