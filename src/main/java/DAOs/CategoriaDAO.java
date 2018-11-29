/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {

    private static Connection conexao;
    private static CategoriaDAO dao;
    private final String SQL_INSERT_CATEGORIA = "INSERT INTO CATEGORIA(categoria) VALUES (?)";
    private final String SQL_ALL_CATEGORIA = "SELECT ID_CATEGORIA FROM CATEGORIA";
    private final String SQL_CATEGORIA_BY_ID = "SELECT * FROM CATEGORIA WHERE ID_CATEGORIA = ?";
    private final String SQL_UPDATE_CATEGORIA = "UPDATE CATEGORIA SET CATEGORIA = ? WHERE ID_CATEGORIA = ?";

    private CategoriaDAO() throws SQLException, ClassNotFoundException {
        CategoriaDAO.conexao = Conexao.getConexao();
    }

    public static CategoriaDAO getInstance() {
        if (dao == null) {
            try {
                dao = new CategoriaDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;

    }

    public void editar(Categoria categoria) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_UPDATE_CATEGORIA)) {
            comando.setString(1, categoria.getCategoria());
            comando.setInt(2, categoria.getId());
            comando.execute();
            comando.close();
        }
    }

    public void adicionar(Categoria categoria) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(SQL_INSERT_CATEGORIA)) {
            comando.setString(1, categoria.getCategoria());
            comando.execute();
            comando.close();
        }
    }

    public List<Categoria> getAllCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(SQL_ALL_CATEGORIA)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    categorias.add(this.getCategoriaById(resultado.getInt("id_categoria")));
                } while (resultado.next());
            }
        }
        return categorias;
    }

    public Categoria getCategoriaById(Integer id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement comando = conexao.prepareStatement(SQL_CATEGORIA_BY_ID)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                categoria = new Categoria().setId(resultado.getInt("id_categoria")).setCategoria(resultado.getString("categoria"));
            }
            comando.close();
        }
        return categoria;
    }

        public List<Categoria> getAllCategoriaAndItens() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(SQL_ALL_CATEGORIA)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    categorias.add(this.getCategoriaById(resultado.getInt("id_categoria"))
                            .setItens(ItemDAO.getInstance().getItensByCategoria(resultado.getInt("id_categoria"))));
                } while (resultado.next());
            }
        }
        return categorias;
    }

}
