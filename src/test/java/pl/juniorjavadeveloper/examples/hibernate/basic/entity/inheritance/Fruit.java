package pl.juniorjavadeveloper.examples.hibernate.basic.entity.inheritance;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Fruit {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return name;
    }

    public void setBase(String name) {
        this.name = name;
    }
}
