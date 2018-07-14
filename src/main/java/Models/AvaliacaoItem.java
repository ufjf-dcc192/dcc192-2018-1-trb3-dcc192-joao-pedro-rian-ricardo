package Models;

public class AvaliacaoItem {
    private Integer id;
    private Integer positiva;
    private Integer negativa;
    private Usuario usuario;
    private Item item; 

    public AvaliacaoItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositiva() {
        return positiva;
    }

    public void setPositiva(Integer positiva) {
        this.positiva = positiva;
    }

    public Integer getNegativa() {
        return negativa;
    }

    public void setNegativa(Integer negativa) {
        this.negativa = negativa;
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
