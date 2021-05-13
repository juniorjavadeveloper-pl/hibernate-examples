package pl.juniorjavadeveloper.examples.hibernate.basic.configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    private Long id;

    public Event() {
    }

    public Event(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
