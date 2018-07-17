package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Item {
    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Usuario usuario;
    private List<Comentario> comentarios;
    private List<Link> links;
    private List<AvaliacaoItem> avaliacoes;
    private Integer totalPositivas;
    private Integer totalNegativas;
    private Integer avaliacaofinal;
    private boolean comentado;
    private boolean avaliado;

    public boolean isComentado() {
        return comentado;
    }

    public void setComentado(boolean comentado) {
        this.comentado = comentado;
    }

    public boolean isAvaliado() {
        return avaliado;
    }

    public void setAvaliado(boolean avaliado) {
        this.avaliado = avaliado;
    }
    
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

    
    public List<AvaliacaoItem> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoItem> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
    public String getStringDataAtu(){
        return this.dataAtualizacao.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
    
    public String getStringDataCriacao(){
        return this.dataCriacao.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
