package pl.juniorjavadeveloper.examples.hibernate.basic.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class Banana extends Fruit {
    private String description;
    private String type;

    public Banana() {
    }

    public Banana(String name, String description, String type) {
        super(name);
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
