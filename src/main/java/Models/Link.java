package Models;

import java.util.ArrayList;
import java.util.List;

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

    public Link(Integer id, String link) {
        this.id = id;
        this.link = link;
    }

    private Link(String link) {
        this.link = link;
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

    public static List<Link> StringToListLink(String[] links) {
        List<Link> linksList = new ArrayList<>();
        for (String Strlink : links) {
            Link link = new Link(Strlink);
            linksList.add(link);
        }
        return linksList;
    }

}
