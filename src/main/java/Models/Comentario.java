package Models;

import java.time.LocalDateTime;
import java.util.List;


public class Comentario {
    private Integer id;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Usuario usuario;
    private Item item;
    private List<AvaliacaoComentario> avaliacoes;   
    private Integer totalPositivas;
    private Integer totalNegativas;
    private Integer avaliacaofinal;

    public Integer getTotalPositivas() {
        return totalPositivas;
    }

    public void setTotalPositivas(Integer totalPositivas) {
        this.totalPositivas = totalPositivas;
    }

    public Integer getTotalNegativas() {
        return totalNegativas;
    }

    public void setTotalNegativas(Integer totalNegativas) {
        this.totalNegativas = totalNegativas;
    }

    public Integer getAvaliacaofinal() {
        return avaliacaofinal;
    }

    public void setAvaliacaofinal(Integer avaliacaofinal) {
        this.avaliacaofinal = avaliacaofinal;
    }


    public Comentario(Integer id, String comentario, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, Usuario usuario, Item item, List<AvaliacaoComentario> avaliacoes) {
        this.id = id;
        this.comentario = comentario;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
        this.item = item;
        this.avaliacoes = avaliacoes;
    }

    public Comentario(String comentario, Usuario usuario, Item item) {
        this.comentario = comentario;
        this.usuario = usuario;
        this.item = item;
    }    
    
    public List<AvaliacaoComentario> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoComentario> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    

    public Comentario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
   
    
    
    
}
