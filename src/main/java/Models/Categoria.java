
package Models;

import java.util.List;

public class Categoria {
    Integer id;
    String categoria;
    List<Item> itens;

    public Categoria() {}

    public Integer getId() {
        return id;
    }

    public Categoria setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public Categoria setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Categoria setItens(List<Item> itens) {
        this.itens = itens;
        return this;
    }
    
    
}
