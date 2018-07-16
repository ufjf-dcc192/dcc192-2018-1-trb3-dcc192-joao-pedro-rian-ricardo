/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import DAOs.ItemDAO;
import DAOs.UsuarioDAO;
import Models.Item;
import Models.Usuario;
import java.io.IOException;
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
public class ComentarCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuarioID");
            Integer idItem = Integer.parseInt(request.getParameter("item"));
            request.setAttribute("usuario", idUsuario);
            request.setAttribute("item", idItem);
            request.setAttribute("enviado", null);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/comentar.jsp");
            despachante.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ComentarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
