package pl.juniorjavadeveloper.examples.hibernate.basic.entity.inheritance;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vegetable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private NutritionFact nutritionFact;

    public Vegetable() {
    }

    public Vegetable(String name, NutritionFact nutritionFact) {
        this.name = name;
        this.nutritionFact = nutritionFact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionFact getNutritionFact() {
        return nutritionFact;
    }

    public void setNutritionFact(NutritionFact nutritionFact) {
        this.nutritionFact = nutritionFact;
    }
}
