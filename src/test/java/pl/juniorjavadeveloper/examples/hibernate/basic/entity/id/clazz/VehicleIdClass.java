package pl.juniorjavadeveloper.examples.hibernate.basic.entity.id.clazz;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VehicleIdClass implements Serializable {
    private String vin;
    private String registrationNumber;

    public VehicleIdClass() {
    }

    public VehicleIdClass(String vin, String registrationNumber) {
        this.vin = vin;
        this.registrationNumber = registrationNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
