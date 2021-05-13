package pl.juniorjavadeveloper.examples.hibernate.basic.entity.inheritance;

import javax.persistence.Embeddable;

@Embeddable
public class NutritionFact {
    private String fat;
    private String protein;
    private String carbohydrate;

    public NutritionFact() {
    }

    public NutritionFact(String fat, String protein, String carbohydrate) {
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
