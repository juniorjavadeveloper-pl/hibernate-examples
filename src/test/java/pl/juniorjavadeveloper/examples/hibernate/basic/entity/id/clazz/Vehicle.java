package pl.juniorjavadeveloper.examples.hibernate.basic.entity.id.clazz;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(VehicleIdClass.class)
@Table(name = "VEHICLES")
public class Vehicle {
    @Id
    private String vin;
    @Id
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(String vin, String registrationNumber) {
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
