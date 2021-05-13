package pl.juniorjavadeveloper.examples.hibernate.basic.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ZOO")
public class Animal {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date date;
    private String name;

    public Animal() {
    }

    public Animal(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
