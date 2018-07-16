package DAOs;

import Models.AvaliacaoItem;
import Models.Item;
import Models.Link;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;

public class ItemDAO {

    private static Connection conexao;
    private static ItemDAO dao;

    public ItemDAO() throws SQLException, ClassNotFoundException {
        ItemDAO.conexao = Conexao.getConexao();
    }

    public static ItemDAO getInstance() {
        if (dao == null) {
            try {
                dao = new ItemDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;
    }

    public Item getItemById(Integer id) {
        String sql = "SELECT * FROM ITEM WHERE ID = ?";
        Item item = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                item = new Item();
                item.setId(resultado.getInt(1));
                item.setUsuario(UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)));
                item.setTitulo(resultado.getString(3));
                item.setDescricao(resultado.getString(4));
                item.setDataCriacao(resultado.getTimestamp(5).toLocalDateTime());
                item.setDataAtualizacao(resultado.getTimestamp(6).toLocalDateTime());
                item.setLinks(this.getLinks(item));
                item.setAvaliacoes(this.getAvaliacoes(item));
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public List<Link> getLinks(Item item) {
        String sql = "SELECT * FROM links(?)";
        List<Link> links = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, item.getId());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    links.add(new Link(resultado.getInt(1), resultado.getString(2), item));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return links;
    }

    public List<AvaliacaoItem> getAvaliacoes(Item item) {
        String sql = "SELECT * FROM avaliacao_item where id_item = ?";
        List<AvaliacaoItem> avaliacoes = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, item.getId());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    avaliacoes.add(new AvaliacaoItem(resultado.getInt(1), resultado.getInt(4), resultado.getInt(5), UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)), item));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avaliacoes;
    }

    public void adicionarItem(Item item) {

    }

    public void adicionarLinks(Item item) {
    }

    public void editarItem(Item item) {
    }

    public void editarLinks(Item item) {
    }

    public void excluirItem(Integer id) {
    }

    public void excluirLinks(Integer id) {
    }

    public List<Item> aAvaliar(Integer idUsuario) {
        String sql = "SELECT id FROM ITEM WHERE ID NOT IN (\n"
                + "              	SELECT ID_ITEM\n"
                + "              	FROM COMENTARIO\n"
                + "              	WHERE ID_USUARIO = ?  	) or\n"
                + "  	ID not IN (\n"
                + "           	SELECT ID_ITEM\n"
                + "  	         FROM AVALIACAO_ITEM\n"
                + "           	WHERE ID_USUARIO = ?\n"
                + "  	)";
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idUsuario);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                   itens.add(this.getItemById(resultado.getInt(1)));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;

    }

    public List<Usuario> trolls() {
        return null;
    }

    public List<Usuario> curadores() {
        return null;
    }

}
