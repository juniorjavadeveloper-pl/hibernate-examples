package pl.juniorjavadeveloper.examples.hibernate.basic.relationship.one_to_many;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENUS")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    // * unidirectional -> class Menu: @OneToMany List<Item> items
    // 1. @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) - with intermediate table
    // 2. @JoinColumn(name = "MENU_ID")  - without intermediate table
    // * bidirectional -> class Item: @ManyToOne Menu menu;
    // 1. @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  - with intermediate table
    // 2. @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true) - without intermediate table
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Menu() {
    }

    public Menu(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setMenu(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setMenu(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getOrders() {
        return items;
    }

    public void setOrders(List<Item> items) {
        this.items = items;
    }
}
