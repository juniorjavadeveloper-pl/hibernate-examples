package pl.juniorjavadeveloper.examples.hibernate.basic.relationship.one_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_BOOKS")
public class StudentBook {
    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @OneToOne(mappedBy = "studentBook")  // NOTE: check without 'mappedBy'
    private Student student;

    public StudentBook() {
    }

    public StudentBook(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
