package models;

public class FlightDTO {

    private String id_flight;
    private String id_aircraft;
    private String id_itinerary;
    private String id_passenger;


    public String getId_flight() {
        return id_flight;
    }

    public void setId_flight(String id_flight) {
        this.id_flight = id_flight;
    }

    public String getId_aircraft() {
        return id_aircraft;
    }

    public void setId_aircraft(String id_aircraft) {
        this.id_aircraft = id_aircraft;
    }

    public String getId_itinerary() {
        return id_itinerary;
    }

    public void setId_itinerary(String id_itinerary) {
        this.id_itinerary = id_itinerary;
    }

    public String getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(String id_passenger) {
        this.id_passenger = id_passenger;
    }
}
