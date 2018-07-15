package Models;

public class Link {
    private Integer id;
    private String link;
    private Item item;

    public Link() {
    }

    public Link(Integer id, String link, Item item) {
        this.id = id;
        this.link = link;
        this.item = item;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
        
    
}
