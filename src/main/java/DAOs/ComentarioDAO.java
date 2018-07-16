package DAOs;

import Models.AvaliacaoComentario;
import Models.AvaliacaoItem;
import Models.Comentario;
import Models.Item;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDAO {

    private static Connection conexao;
    private static ComentarioDAO dao;

    public ComentarioDAO() throws SQLException, ClassNotFoundException {
        ComentarioDAO.conexao = Conexao.getConexao();
    }

    public static ComentarioDAO getInstance() {
        if (dao == null) {
            try {
                dao = new ComentarioDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;

    }

    public Comentario getComentarioById(int id) {
        String sql = "SELECT * FROM COMENTARIO WHERE ID = ?";
        Comentario comentario = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            comentario = new Comentario();
            comentario.setId(resultado.getInt(1));
            comentario.setItem(ItemDAO.getInstance().getItemById(resultado.getInt(3)));
            comentario.setUsuario(UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)));
            comentario.setComentario(resultado.getString(4));
            comentario.setDataCriacao(resultado.getTimestamp(5).toLocalDateTime());
            comentario.setDataAtualizacao(resultado.getTimestamp(6).toLocalDateTime());
            comentario.setAvaliacoes(this.getAvaliacoes(comentario));
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentario;
    }

    public List<Comentario> getComentariobyItem(Item item) {
        String sql = "SELECT * FROM COMENTARIO WHERE ID_ITEM = ? ORDER BY DATA_CRIACAO";
        List<Comentario> comentarios = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, item.getId());
            ResultSet resultado = comando.executeQuery();
            Comentario comentario = new Comentario();
            comentario.setId(resultado.getInt(1));
            comentario.setItem(item);
            comentario.setUsuario(UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)));
            comentario.setComentario(resultado.getString(4));
            comentario.setDataCriacao(resultado.getTimestamp(5).toLocalDateTime());
            comentario.setDataAtualizacao(resultado.getTimestamp(6).toLocalDateTime());
            comentario.setAvaliacoes(this.getAvaliacoes(comentario));
            comentarios.add(comentario);
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }

    public List<AvaliacaoComentario> getAvaliacoes(Comentario comentario) {
        String sql = "SELECT * FROM avaliacao_comentario where id_comentario = ?";
        List<AvaliacaoComentario> avaliacoes = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, comentario.getId());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    avaliacoes.add(new AvaliacaoComentario(resultado.getInt(1), resultado.getInt(4), resultado.getInt(5), UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)), comentario));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avaliacoes;

    }

    public void adicionarComentario(Comentario comentario) {
        String sql = "INSERT INTO \n"
                + "  public.comentario\n"
                + "(\n"
                + "  id_usuario,\n"
                + "  id_item,\n"
                + "  comentario,\n"
                + "  data_criacao,\n"
                + "  data_atualizacao\n"
                + ")\n"
                + "VALUES (\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  current_timestamp,\n"
                + "  current_timestamp\n"
                + ")";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, comentario.getUsuario().getId());
            comando.setInt(2, comentario.getItem().getId());
            comando.setString(3, comentario.getComentario());
            comando.execute();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Comentario> getComentariosByUsuario(int idUsuario) {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM COMENTARIO INNER JOIN ITEM ON(ITEM.ID = COMENTARIO.ID_ITEM) WHERE ID_USUARIO = ?";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idUsuario);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Item item = ItemDAO.getInstance().getItemById(resultado.getInt(3));
                    Usuario usuario = UsuarioDAO.getInstance().getUsuarioById(idUsuario);
                    comentarios.add(new Comentario(resultado.getString(4), usuario, item));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }
}
