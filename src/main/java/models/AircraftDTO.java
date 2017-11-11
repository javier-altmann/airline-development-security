package models;

public class AircraftDTO {

    private String id_aircraft;
    private String brand;
    private String model;
    private String id_seat;
    private String registrationNumber;

    public String getId_aircraft() {
        return id_aircraft;
    }

    public void setId_aircraft(String id_aircraft) {
        this.id_aircraft = id_aircraft;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId_seat() {
        return id_seat;
    }

    public void setId_seat(String id_seat) {
        this.id_seat = id_seat;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}